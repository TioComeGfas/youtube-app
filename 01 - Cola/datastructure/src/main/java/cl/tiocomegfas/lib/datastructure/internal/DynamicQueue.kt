package cl.tiocomegfas.lib.datastructure.internal

import cl.tiocomegfas.lib.datastructure.Queue
import cl.tiocomegfas.lib.datastructure.internal.Constants.EMPTY_STATE
import cl.tiocomegfas.lib.datastructure.internal.Constants.MESSAGE_EMPTY
import cl.tiocomegfas.lib.datastructure.internal.Constants.MESSAGE_INVALID_DATA

internal class DynamicQueue<T>: Queue<T> {
    private var last: Node<T>? = null
    private var root: Node<T>? = null
    private var size: Int = 0

    override suspend fun offer(element: T) {
        val newNode = Node(
            data = element,
            next = null
        )

        size++
        if(isEmpty()) {
            root = newNode
            last = newNode
            return
        }

        last?.next = newNode
        last = newNode
    }

    override suspend fun poll(): T {
        if(isEmpty()) throw ArrayIndexOutOfBoundsException(MESSAGE_EMPTY)
        val recovery = root?.data ?: throw IllegalStateException(MESSAGE_INVALID_DATA)
        size--
        root = root?.next
        return recovery
    }

    override suspend fun element(): T {
        if(isEmpty()) throw ArrayIndexOutOfBoundsException(MESSAGE_EMPTY)
        return root?.data ?: throw IllegalStateException(MESSAGE_INVALID_DATA)
    }

    override suspend fun isEmpty(): Boolean {
        return root == null
    }

    override suspend fun getAll(): List<T> {
        if(isEmpty()) return emptyList()
        val result = mutableListOf<T>()
        var count = 0
        var copy = root
        while(count < (size + 1)) {
            copy?.data?.let { content ->
                result.add(content)
            }
            copy = copy?.next
            count++
        }
        return result
    }
}