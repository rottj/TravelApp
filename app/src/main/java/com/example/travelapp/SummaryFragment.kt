package com.example.travelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.travelapp.databinding.FragmentSummaryBinding
import com.example.travelapp.model.ReservationViewModel


class SummaryFragment : Fragment() {

    private var binding: FragmentSummaryBinding? = null


    private val sharedViewModel: ReservationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun sendOrder() {
        //intent
    }


    fun cancelReservation() {
        sharedViewModel.resetReservation()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}