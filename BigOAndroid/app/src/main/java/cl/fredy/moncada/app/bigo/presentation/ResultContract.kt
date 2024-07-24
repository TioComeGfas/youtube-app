package cl.fredy.moncada.app.bigo.presentation

interface ResultContract {

    sealed interface State {
        data object Initial: State
        data object Error: State
    }

    sealed interface Event {
        data object OnCalculate: Event
    }

    sealed interface Effect {
        data object Loading: Effect
    }

}