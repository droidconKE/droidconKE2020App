package com.android254.droidconKE2020.auth.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.android254.droidconKE2020.auth.R
import com.android254.droidconKE2020.auth.authModule
import com.android254.droidconKE2020.auth.databinding.DialogAuthenticateBinding
import com.android254.droidconKE2020.auth.viewModels.AuthFlow
import com.android254.droidconKE2020.auth.viewModels.AuthViewModel
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf

private val loadFeature by lazy { loadKoinModules(authModule) }
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
    lateinit var resultLauncher: ActivityResultLauncher<IntentSenderRequest>

    private val TAG = javaClass.name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    it.data?.let { intent ->
                        val token = authFlow.getToken(intent)
                        if (token == null) {
                            Toast.makeText(
                                requireContext(),
                                "Google sign in failed",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@let
                        }
                        viewModel.signIn(token)
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

        viewModel.startSignInProcess.observe(viewLifecycleOwner, {
            viewLifecycleOwner.lifecycleScope.launch {
                try {
                    val intent = authFlow.getSignInIntent()
                    val request = IntentSenderRequest.Builder(intent)
                        .build()
                    resultLauncher.launch(request)
                } catch (e: ApiException) {
                    Log.w(TAG, "signInResult:failed code=${e.statusCode}")
                }
            }
        })
    }


}