package com.example.travelapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.travelapp.model.ReservationViewModel
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun destination_warsaw() {
        val viewModel = ReservationViewModel()
        viewModel.destination.observeForever {}
        viewModel.setDestination("Warsaw")
        assertEquals("Warsaw", viewModel.destination.value)
    }

    @Test
    fun length_3_days_transport_own() {
        val viewModel = ReservationViewModel()
        viewModel.price.observeForever {}

        viewModel.setLength(3)
        viewModel.setTransport("Own transport")

        assertEquals("300,00 zł", viewModel.price.value)

    }
}
