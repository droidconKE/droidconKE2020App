package com.android254.droidconKE2020.about.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.droidconKE2020.core.models.OrganizerUIModel
import com.android254.droidconKE2020.core.utils.SingleLiveEvent
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.organizers.OrganizersRepository
import kotlinx.coroutines.launch

/**
 * 11/04/20
 */
class OrganizerViewModel(private val organizersRepository: OrganizersRepository) : ViewModel() {
    private var _organizers = MutableLiveData<List<OrganizerUIModel>>()
    val organizers = _organizers
    val showToast = SingleLiveEvent<String>()


    fun fetchOrganizers(){
        viewModelScope.launch {
            when(val value = organizersRepository.fetchOrganizers()){
                is Data.Success -> _organizers.postValue(value.data)
                is Data.Error -> showToast.postValue(value.exception.toString())
            }
        }
    }
}