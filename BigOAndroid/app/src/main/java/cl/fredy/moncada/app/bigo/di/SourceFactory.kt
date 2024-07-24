package cl.fredy.moncada.app.bigo.di

import cl.fredy.moncada.app.bigo.data.source.cache.CacheDataSource
import cl.fredy.moncada.app.bigo.data.source.cache.CacheDataSourceImpl
import cl.fredy.moncada.app.bigo.data.source.local.LocalDataSource
import cl.fredy.moncada.app.bigo.data.source.local.LocalDataSourceImpl

object SourceFactory {

    fun createLocal(): LocalDataSource {
        return LocalDataSourceImpl()
    }

    fun createCache(): CacheDataSource {
        return CacheDataSourceImpl()
    }
}