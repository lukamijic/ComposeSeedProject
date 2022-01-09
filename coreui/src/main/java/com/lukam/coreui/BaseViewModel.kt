package com.lukam.coreui

import androidx.lifecycle.ViewModel
import com.lukam.core.extensions.mutableShareFlow
import com.lukam.core.extensions.mutableStateFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

abstract class BaseViewModel<ViewState : Any, Event : Any> : ViewModel() {

    private val loggingHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
    }

    private val initialState by lazy { createInitialState() }

    private val _viewState = mutableStateFlow(initialState)
    val viewState: Flow<ViewState> = _viewState

    private val events = mutableShareFlow<Event>()

    private val bgScope = CoroutineScope(Dispatchers.Default + SupervisorJob() + loggingHandler)

    abstract fun createInitialState(): ViewState

    init {
        observeEvents()
    }

    fun publishEvent(event: Event) {
        runCommand { events.emit(event) }
    }

    protected fun <T> query(flow: Flow<T>, t: T, reducer: ViewState.(T) -> ViewState) {
        bgScope.launch {
            flow.collect {
                val newValue = _viewState.value.reducer(it)
                _viewState.emit(newValue)
            }
        }
    }

    protected fun runCommand(action: suspend () -> Unit) = bgScope.launch { action() }

    protected abstract fun processEvents(event: Event)

    private fun observeEvents() {
        bgScope.launch {
            events
                .collect { event -> processEvents(event) }
        }
    }

    override fun onCleared() {
        bgScope.cancel()
        super.onCleared()
    }
}
