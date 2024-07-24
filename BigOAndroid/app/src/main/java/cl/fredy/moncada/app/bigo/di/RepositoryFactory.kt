package cl.fredy.moncada.app.bigo.di

import cl.fredy.moncada.app.bigo.data.repository.Repository
import cl.fredy.moncada.app.bigo.data.repository.RepositoryImpl
import cl.fredy.moncada.app.bigo.data.source.cache.CacheDataSource
import cl.fredy.moncada.app.bigo.data.source.local.LocalDataSource

object RepositoryFactory {

    fun create(
        local: LocalDataSource,
        cache: CacheDataSource
    ): Repository {
        return RepositoryImpl(
            local = local,
            cache = cache
        )
    }
}