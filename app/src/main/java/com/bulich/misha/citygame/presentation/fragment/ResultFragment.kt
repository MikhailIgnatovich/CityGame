package com.bulich.misha.citygame.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bulich.misha.citygame.R
import com.bulich.misha.citygame.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private val args by navArgs<ResultFragmentArgs>()

    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = _binding ?: throw RuntimeException("FragmentResultBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scopeCountTv.text = "Очки: ${args.scopeCount}"

        binding.repeatButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.exitButton.setOnClickListener {
            activity?.finish()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}