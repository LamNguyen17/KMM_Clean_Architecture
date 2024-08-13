package com.forest.kmm_clean_architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual open class BaseViewModel: ViewModel() {
    actual val scope = viewModelScope
}