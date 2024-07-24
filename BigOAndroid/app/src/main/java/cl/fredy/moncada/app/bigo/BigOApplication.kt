package cl.fredy.moncada.app.bigo

import android.app.Application
import cl.fredy.moncada.app.bigo.data.repository.Repository
import cl.fredy.moncada.app.bigo.di.RepositoryFactory
import cl.fredy.moncada.app.bigo.di.SourceFactory

class BigOApplication: Application() {

    private var repository: Repository? = null

    override fun onCreate() {
        super.onCreate()
        repository = RepositoryFactory.create(
            local = SourceFactory.createLocal(),
            cache = SourceFactory.createCache()
        )

    }


    override fun onTerminate() {
        super.onTerminate()
        repository = null
    }
}