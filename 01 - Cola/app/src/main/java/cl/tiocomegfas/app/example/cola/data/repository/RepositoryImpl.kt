package cl.tiocomegfas.app.example.cola.data.repository

import cl.tiocomegfas.lib.datastructure.Queue

class RepositoryImpl(
    private val queue: Queue<String>
): Repository {
    override suspend fun insertItem(item: String) {
        queue.offer(item)
    }

    override suspend fun topItem(): String {
        return queue.element()
    }

    override suspend fun deleteItem(): String {
        return queue.poll()
    }

    override suspend fun getAllItems(): List<String> {
        return queue.getAll()
    }

}