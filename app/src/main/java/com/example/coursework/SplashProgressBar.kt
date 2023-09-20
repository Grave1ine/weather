package com.example.coursework

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.coursework.databinding.FragmentProgressBarBinding
import dagger.hilt.android.AndroidEntryPoint

//сплэш с загрузкой
//@AndroidEntryPoint
class SplashProgressBar : Fragment() {

    private var binding: FragmentProgressBarBinding? = null

    private inline fun withBinding(block: FragmentProgressBarBinding.() -> Unit) {      //чтобы не проверять каждый раз на нулл
        binding?.block()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProgressBarBinding.inflate(layoutInflater, container, false)

        Handler(Looper.myLooper()!!).postDelayed({
        findNavController().navigate(R.id.action_splash_to_main_Screen)
        },1500)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.progressBar.max = 100

        val currentProgress = 100

        ObjectAnimator.ofInt(binding!!.progressBar, "progress", currentProgress)
            .setDuration(1400)
            .start()
    }


}