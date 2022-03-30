package com.example.kotlinphotos.ui.doodle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinphotos.model.Photo
import com.example.kotlinphotos.model.Type
import com.example.kotlinphotos.model.Type.*
import com.example.kotlinphotos.repository.DoodleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DoodleViewModel(
    private val repository: DoodleRepository
) : ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>>
        get() = _photos

    init {
        loadDoodlePhotos()
    }

    private fun loadDoodlePhotos() {
        val doodles = repository.loadDoodlePhotos()
        _photos.value = doodles
    }

    fun updateEditMode() {
        _photos.value?.forEach { photo ->
            photo.mode = EDIT
        }
    }

    fun check(position: Int) {
        val photo = _photos.value?.get(position)
        photo?.let {
            if (it.mode == EDIT) {
                it.isChecked = true
            }
        }
    }
}