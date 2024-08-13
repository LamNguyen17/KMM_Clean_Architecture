package com.forest.kmm_clean_architecture.photo.presentation

import com.forest.kmm_clean_architecture.BaseViewModel
import com.forest.kmm_clean_architecture.photo.domain.PhotosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotosViewModel(
    private val useCase: PhotosUseCase
): BaseViewModel() {

    private val _photosState: MutableStateFlow<PhotosState> = MutableStateFlow(PhotosState(loading = true))

    val photosState: StateFlow<PhotosState> get() = _photosState
    init {
        getPhotos()
        println("Running on init")
    }

    fun getPhotos(forceFetch: Boolean = false) {
        scope.launch {
            _photosState.emit(PhotosState(loading = true, photos = _photosState.value.photos))
            val fetchedPhotos = useCase.getPhotos(forceFetch)
            _photosState.emit(PhotosState(photos = fetchedPhotos))
        }
    }
}