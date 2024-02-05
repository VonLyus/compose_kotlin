package com.example.clonecodingjan

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val url = mutableStateOf("https://www.google.com")

    private val _undoSharedFlow = MutableSharedFlow<Boolean>()// flow와 다르게 default값을 설정할 필요 없다
    val undoSharedFlow = _undoSharedFlow.asSharedFlow()

    private val _redoSharedFlow = MutableSharedFlow<Boolean>()
    val redoSharedFlow = _redoSharedFlow.asSharedFlow()

    fun undo(){
        viewModelScope.launch {
            _undoSharedFlow.emit(true)
        }
    }
    fun redo(){
        viewModelScope.launch {
            _redoSharedFlow.emit(true)
        }
    }
}