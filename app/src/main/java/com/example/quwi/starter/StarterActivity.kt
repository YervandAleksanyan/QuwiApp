package com.example.quwi.starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.quwi.R
import com.example.quwi.databinding.ActivityStarterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StarterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStarterBinding

    private val viewModel: StarterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.checkIsAuthenticated()
        viewModel.isAuthenticated.observe(this) {
            val navController = findNavController(R.id.container)
            navController.graph = navController.navInflater.inflate(R.navigation.main_nav_graph).apply {
                setStartDestination(
                    if (it) {
                        R.id.chatsFragment
                    } else {
                        R.id.logInFragment
                    }
                )
            }
            if (it) {
                navController.navigate(R.id.action_global_chats_fragment)
            } else {
                navController.navigate(R.id.action_global_loginFragment)
            }
        }
    }

}