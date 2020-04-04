package com.android254.droidconKE2020.auth.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.android254.droidconKE2020.auth.databinding.DialogAuthenticateBinding
import com.android254.droidconKE2020.auth.di.authModule
import org.koin.core.context.loadKoinModules

private val loadFeature by lazy { loadKoinModules(authModule) }
private fun injectFeature() = loadFeature

class AuthDialog : DialogFragment() {
    lateinit var binding: DialogAuthenticateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogAuthenticateBinding.inflate(inflater, container, false)
        return binding.root
    }
}