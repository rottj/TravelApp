package com.example.travelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.travelapp.databinding.FragmentStartBinding
import com.example.travelapp.model.ReservationViewModel


class StartFragment : Fragment() {

    private var binding: FragmentStartBinding? = null

    private val sharedViewModel: ReservationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    fun chooseDestination(city: String){
        sharedViewModel.setDestination(city)
        findNavController().navigate(R.id.action_startFragment_to_lengthFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}