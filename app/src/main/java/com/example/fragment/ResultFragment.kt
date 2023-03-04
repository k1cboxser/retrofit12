package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.retrofit12.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result = arguments?.getString(MainFragment.RESULT)
        val ed_me = arguments?.getString(MainFragment.ED_ME)
        val ed_you = arguments?.getString(MainFragment.ED_YOU)
        binding.tvme.text = ed_me.toString()
        binding.tvyou.text = ed_you.toString()
        binding.tvResult.text = result.toString()


    }
}