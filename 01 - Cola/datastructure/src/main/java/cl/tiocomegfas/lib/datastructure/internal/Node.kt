package cl.tiocomegfas.lib.datastructure.internal

internal data class Node<T>(
    var data: T,
    var next: Node<T>? = null
)