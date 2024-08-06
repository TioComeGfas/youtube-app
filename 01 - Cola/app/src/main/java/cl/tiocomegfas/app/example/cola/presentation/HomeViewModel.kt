package cl.tiocomegfas.app.example.cola.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.tiocomegfas.app.example.cola.data.repository.Repository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
): ViewModel(), HomeContract {
    private var _state: MutableStateFlow<HomeContract.State> = MutableStateFlow(HomeContract.State())
    private var _effect: MutableSharedFlow<HomeContract.Effect> = MutableSharedFlow()

    override val effect: SharedFlow<HomeContract.Effect>
        get() = _effect.asSharedFlow()
    override val state: StateFlow<HomeContract.State>
        get() = _state.asStateFlow()

    override fun onEvent(event: HomeContract.Event) {
        when(event) {
            is HomeContract.Event.OnAddItem -> addItem(event.newItem)
            HomeContract.Event.OnDeleteItem -> deleteItem()
            HomeContract.Event.OnLoadItems -> loadItems()
        }
    }

    private fun deleteItem() {
        viewModelScope.launch {
            runCatching {
                repository.deleteItem()
            }.getOrNull()
            loadItems()
        }
    }

    private fun addItem(newItem: String) {
        viewModelScope.launch {
            repository.insertItem(newItem)
            loadItems()
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            val items = runCatching {
                repository.getAllItems()
            }.getOrDefault(emptyList())
            val top = runCatching {
                repository.topItem()
            }.getOrDefault(" ")
            _state.emit(
                HomeContract.State(
                    items = items,
                    top = top
                )
            )
        }
    }
}