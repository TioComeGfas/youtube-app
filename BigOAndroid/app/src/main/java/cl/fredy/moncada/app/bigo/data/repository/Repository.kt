package cl.fredy.moncada.app.bigo.data.repository

import cl.fredy.moncada.app.bigo.data.entity.request.ExecuteBigORequest
import cl.fredy.moncada.app.bigo.data.entity.response.ExecuteBigOResponse
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun executeBigO(request: ExecuteBigORequest): ExecuteBigOResponse
}