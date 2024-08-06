@file:Suppress("UNCHECKED_CAST")

package cl.tiocomegfas.app.example.cola.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.tiocomegfas.app.example.cola.presentation.HomeViewModel

object ViewModelFactory {

    fun createHome(): ViewModelProvider.Factory {
        return object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                    return HomeViewModel(
                        repository = RepositoryFactory.create()
                    ) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}