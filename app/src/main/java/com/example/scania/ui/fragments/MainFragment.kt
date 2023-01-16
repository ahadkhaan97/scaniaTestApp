package com.example.scania.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scania.R
import com.example.scania.databinding.FragmentMainBinding
import com.example.scania.utils.setSafeOnClickListener


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            FragmentMainBinding.inflate(inflater, container, false)

        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.tvNext.setSafeOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_countriesFragment)
        }
    }
}