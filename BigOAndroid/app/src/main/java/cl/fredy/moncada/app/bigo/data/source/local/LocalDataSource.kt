package cl.fredy.moncada.app.bigo.data.source.local

interface LocalDataSource {

    suspend fun executeConstant(): Long

    suspend fun executeLinear(): Long

    suspend fun executeQuadratic(): Long

    suspend fun executeLogarithmic(): Long

    suspend fun executeExponential(): Long
}