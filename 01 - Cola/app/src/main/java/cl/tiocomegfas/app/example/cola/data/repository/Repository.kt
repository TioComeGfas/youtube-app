package cl.tiocomegfas.app.example.cola.data.repository

interface Repository {

    suspend fun insertItem(item: String)

    suspend fun topItem(): String

    suspend fun deleteItem(): String

    suspend fun getAllItems(): List<String>
}