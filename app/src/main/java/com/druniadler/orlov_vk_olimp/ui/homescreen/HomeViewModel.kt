package com.druniadler.orlov_vk_olimp.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.druniadler.orlov_vk_olimp.data.api.model.Service
import com.druniadler.orlov_vk_olimp.data.api.model.Services
import com.druniadler.orlov_vk_olimp.data.repository.ServiceRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val serviceRepo: ServiceRepo
): ViewModel() {

    val _state = MutableStateFlow(emptyList<Service>())
    val state: StateFlow<List<Service>>
        get() = _state

    init {
        viewModelScope.launch {
            val services = serviceRepo.getServices()
            _state.value = services.services
        }
    }

}