package com.example.travelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.travelapp.databinding.FragmentTransportBinding
import com.example.travelapp.model.ReservationViewModel


class TransportFragment : Fragment() {
    private var binding: FragmentTransportBinding? = null
    private val sharedViewModel: ReservationViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentTransportBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            transportFragment = this@TransportFragment
        }
    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_transportFragment_to_summaryFragment)
    }

    fun cancelResevation() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}