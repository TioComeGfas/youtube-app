@file:Suppress("UNCHECKED_CAST")

package cl.fredy.moncada.app.bigo.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import cl.fredy.moncada.app.bigo.presentation.ResultViewModel

object ViewModelFactory {

    @Composable
    fun createResult(): ResultViewModel {
        return viewModel(
            factory = object: ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if(!modelClass.isAssignableFrom(ResultViewModel::class.java)) {
                        throw IllegalArgumentException("Unknown ViewModel class")
                    }
                    return ResultViewModel() as T
                }
            }
        )
    }


}