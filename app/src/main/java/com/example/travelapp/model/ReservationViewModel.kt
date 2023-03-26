package com.example.travelapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

private const val PRICE_PER_DAY = 100.00
private const val PRICE_FOR_PLANE = 100.00
private const val PRICE_FOR_BUS = 50.00
private const val PRICE_FOR_TRAIN = 30.00


class ReservationViewModel : ViewModel(){

    private val _destination = MutableLiveData<String>()
    val destination: LiveData<String> = _destination

    private val _length = MutableLiveData<Int>()
    val length: LiveData<Int> = _length

    private val _transport = MutableLiveData<String>()
    val transport: LiveData<String> = _transport


    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {
        resetReservation()
    }

    fun setDestination(pickedDestination: String){
        _destination.value = pickedDestination
        updatePrice()
    }

    fun setLength(pickedLength: Int){
        _length.value = pickedLength
        updatePrice()
    }

    fun setTransport(pickedTransport: String){
        _transport.value = pickedTransport
        updatePrice()
    }

    private fun updatePrice(){
        var calculatedPrice = (length.value?: 0) * PRICE_PER_DAY

        when (transport.value) {
            "Plane" -> calculatedPrice += PRICE_FOR_PLANE
            "Bus" -> calculatedPrice += PRICE_FOR_BUS
            "Train" -> calculatedPrice += PRICE_FOR_TRAIN
        }

        _price.value = calculatedPrice

    }

    fun resetReservation() {
        _length.value = 2
        _transport.value = "Plane"
        _destination.value = ""
        _price.value = 0.0
    }
}