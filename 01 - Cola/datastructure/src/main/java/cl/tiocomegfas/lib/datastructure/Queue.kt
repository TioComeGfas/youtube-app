package cl.tiocomegfas.lib.datastructure

import cl.tiocomegfas.lib.datastructure.internal.DynamicQueue
import cl.tiocomegfas.lib.datastructure.internal.StaticQueue

interface Queue<T> {
    suspend fun offer(element: T)
    suspend fun poll(): T
    suspend fun element(): T
    suspend fun isEmpty(): Boolean

    suspend fun getAll(): List<T>

    object Factory {
        fun <T> createStatic(
            size: Int
        ): Queue<T> {
            return StaticQueue(
                maxSize = size
            )
        }

        fun <T> createDynamic(): Queue<T> {
            return DynamicQueue()
        }
    }
}