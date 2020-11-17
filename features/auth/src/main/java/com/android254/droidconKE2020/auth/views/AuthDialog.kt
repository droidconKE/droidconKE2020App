package com.android254.droidconKE2020.auth.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.android254.droidconKE2020.auth.R
import com.android254.droidconKE2020.auth.authModule
import com.android254.droidconKE2020.auth.databinding.DialogAuthenticateBinding
import com.android254.droidconKE2020.auth.viewModels.AuthFlow
import com.android254.droidconKE2020.auth.viewModels.AuthViewModel
import com.android254.droidconKE2020.repository.repoModule
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf

private val loadFeature by lazy { loadKoinModules(listOf(authModule, repoModule)) }
private fun injectFeature() = loadFeature

class AuthDialog : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_authenticate, container)

    private val viewModel: AuthViewModel by viewModel()
    private val authFlow: AuthFlow by inject { parametersOf(requireContext()) }

    lateinit var binding: DialogAuthenticateBinding
    lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    it.data?.let { intent ->
                        viewLifecycleOwner.lifecycleScope.launch {
                            val token = authFlow.getToken(intent)
                            if (token == null) {
                                Toast.makeText(
                                    requireContext(),
                                    "Google sign in failed",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@launch
                            }
                            viewModel.signIn(token)
                        }
                    } ?: kotlin.run {
                        Log.d(TAG, "Got nothing from google :(")
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogAuthenticateBinding.bind(view)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.closeDialog.observe(
            viewLifecycleOwner,
            {
                dismiss()
            }
        )

        viewModel.showToast.observe(
            viewLifecycleOwner,
            {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        )

        viewModel.startSignInProcess.observe(
            viewLifecycleOwner,
            {
                val intent = authFlow.getSignInIntent()
                resultLauncher.launch(intent)
            }
        )
    }

    companion object {
        private const val TAG = "AuthDialog"
    }
}