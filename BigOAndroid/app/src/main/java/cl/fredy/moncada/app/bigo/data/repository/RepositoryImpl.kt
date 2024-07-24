package cl.fredy.moncada.app.bigo.data.repository

import cl.fredy.moncada.app.bigo.data.source.cache.CacheDataSource
import cl.fredy.moncada.app.bigo.data.source.local.LocalDataSource

class RepositoryImpl(
    private val local: LocalDataSource,
    private val cache: CacheDataSource
): Repository {


}