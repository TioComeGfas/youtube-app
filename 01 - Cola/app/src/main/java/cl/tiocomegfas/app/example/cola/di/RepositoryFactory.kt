package cl.tiocomegfas.app.example.cola.di

import cl.tiocomegfas.app.example.cola.data.repository.Repository
import cl.tiocomegfas.app.example.cola.data.repository.RepositoryImpl
import cl.tiocomegfas.lib.datastructure.Queue

object RepositoryFactory {

    fun create(): Repository {
        return RepositoryImpl(
            queue = Queue.Factory.createDynamic()
        )
    }
}