package com.bulich.misha.citygame.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bulich.misha.citygame.R
import com.bulich.misha.citygame.databinding.FragmentGameBinding
import com.bulich.misha.citygame.presentation.viewmodel.GameViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.RuntimeException


class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null

    private val viewModel by viewModel<GameViewModel>()

    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            blockButtonFalse()
            viewModel.checkAnswer(binding.button1.text.toString())
            buttonColor(it)
        }

        binding.button2.setOnClickListener {
            blockButtonFalse()
            viewModel.checkAnswer(binding.button2.text.toString())
            buttonColor(it)
        }

        binding.button3.setOnClickListener {
            blockButtonFalse()
            viewModel.checkAnswer(binding.button3.text.toString())
            buttonColor(it)
        }

        binding.button4.setOnClickListener {
            blockButtonFalse()
            viewModel.checkAnswer(binding.button4.text.toString())
            buttonColor(it)
        }

        viewModel.question.observe(viewLifecycleOwner) {
            it?.let {
                blockButtonTrue()
                with(binding) {
                    button1.setBackgroundResource(R.drawable.custom_button)
                    button2.setBackgroundResource(R.drawable.custom_button)
                    button3.setBackgroundResource(R.drawable.custom_button)
                    button4.setBackgroundResource(R.drawable.custom_button)
                    button1.text = it.variants[0]
                    button2.text = it.variants[1]
                    button3.text = it.variants[2]
                    button4.text = it.variants[3]
                    countryTv.text = it.question
                }
            }
        }

        viewModel.questionsList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                findNavController()
                    .navigate(GameFragmentDirections.actionGameFragmentToResultFragment(viewModel.scopeCount))
            }
        }

    }

    private fun buttonColor(view: View) {

        if (viewModel.colorButtonWrong) view.setBackgroundResource(R.drawable.wrong_button)

        if (viewModel.colorButtonRight) view.setBackgroundResource(R.drawable.right_button)

    }

    private fun blockButtonFalse() {
        with(binding) {
            button1.isClickable = false
            button2.isClickable = false
            button3.isClickable = false
            button4.isClickable = false
        }
    }

    private fun blockButtonTrue() {
        with(binding) {
            button1.isClickable = true
            button2.isClickable = true
            button3.isClickable = true
            button4.isClickable = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}