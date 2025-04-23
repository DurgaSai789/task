package com.example.hyderabadtask.ui.schedulepic.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hyderabadtask.network.ApiService
import com.example.hyderabadtask.ui.schedulepic.model.ServiceItem
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SchedulePickupViewModel @Inject constructor(private val apiService : ApiService) : ViewModel(){

    private val _transactions = MutableStateFlow<List<ServiceItem>>(emptyList())
    val transactions: StateFlow<List<ServiceItem>> = _transactions

    private val _loading = MutableStateFlow<Boolean>(true)
    val loading : StateFlow<Boolean> = _loading


    fun getDetails() {
        viewModelScope.launch {
            try {
                val response = apiService.getServices()
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        _loading.value = false
                        _transactions.value = it.data
                    }
                } else {
                    Log.e("CHECKING_THE_BODY", "Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CHECKING_THE_BODY", "Exception: ${e.localizedMessage}")
            }
        }
    }
}