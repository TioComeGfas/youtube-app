package cl.tiocomegfas.app.example.cola.presentation

import cl.tiocomegfas.core.architecture.UnidirectionalViewModel

interface HomeContract: UnidirectionalViewModel<HomeContract.State, HomeContract.Event, HomeContract.Effect> {

    data class State(
        val items: List<String> = emptyList(),
        val top: String = " "
    )

    sealed interface Effect {

    }

    sealed interface Event {
        data object OnLoadItems: Event
        data class OnAddItem(val newItem: String): Event
        data object OnDeleteItem: Event
    }

}