package com.example.quwi.feature_authentication.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quwi.R
import com.example.quwi.databinding.FragmentLogInBinding
import com.example.quwi.extensions.hideKeyboard
import com.example.quwi.extensions.viewLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class LogInFragment : Fragment() {
    private var binding: FragmentLogInBinding by viewLifecycle()
    private val viewModel: LogInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLogInBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupViews()
        observeData()
    }

    private fun setupViews() {
        binding.logInButton.setOnClickListener {
            if (viewModel.fieldsAreEmpty(
                    binding.logInField.text.toString(),
                    binding.passwordField.text.toString()
                )
            ) {
                Toast.makeText(context, getString(R.string.login_inputs_validation_message), Toast.LENGTH_SHORT).show()
            } else {
                binding.root.hideKeyboard()
                viewModel.logIn(
                    binding.logInField.text.toString(),
                    binding.passwordField.text.toString()
                )
            }
        }
    }

    private fun observeData() {
        viewModel.isLoginSucceed.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_logInFragment_to_chatsFragment)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }
        viewModel.isLoginFailed.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupToolbar() {
        requireActivity().title = getString(R.string.login_fragment_toolbar_title)
    }
}