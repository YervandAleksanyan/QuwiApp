package com.example.quwi.feature_chats.presentation

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quwi.R
import com.example.quwi.databinding.FragmentChatsListBinding
import com.example.quwi.extensions.viewLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChatsFragment : Fragment() {
    private var binding: FragmentChatsListBinding by viewLifecycle()
    private val viewModel: ChatsViewModel by viewModel()
    private var adapter = ChatsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentChatsListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        setupToolbar()
        observeData()
        getData()
    }

    private fun getData() {
        viewModel.listChats()
    }

    private fun observeData() {
        viewModel.chatsListener.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.chatsEmptyMessageTextView.isVisible = true
                return@observe
            }
            adapter.setData(it)
        }

        viewModel.errorMessageListener.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.logoutEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_global_loginFragment)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
            binding.chatsRecyclerView.isVisible = !it
            binding.chatsEmptyMessageTextView.isVisible = false
            binding.swipeRefreshLayout.isRefreshing = it
        }

    }

    private fun setupRv() {
        binding.chatsRecyclerView.adapter = adapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            getData()
        }
    }

    private fun setupToolbar() {
        requireActivity().title = getString(R.string.chats_toolbar_title)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.chats_menue, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                viewModel.logout()
                return true
            }
        }
        return false
    }
}