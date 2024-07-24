package cl.fredy.moncada.app.bigo.data.source.local

import android.os.SystemClock
import android.util.Log

class LocalDataSourceImpl: LocalDataSource {

    override suspend fun executeConstant(): Long {
        val size = 1000
        val found = 500
        val items: List<Int> = MutableList(size) { it }
        val timeInMs = timeExecution {
            // this action is O(1)
            items[found]
        }
        showLog("Constant time execution: $timeInMs")
        return timeInMs
    }

    override suspend fun executeLinear(): Long {
        val size = 1000
        val items: List<Int> = MutableList(size) { 0 }
        val timeInMs = timeExecution {
            var draftValue = 0
            items.forEach {
                // this action is O(n)
                draftValue++
            }
        }
        showLog("Linear time execution: $timeInMs")
        return timeInMs
    }

    override suspend fun executeQuadratic(): Long {
        val size = 1000
        val items: List<List<Int>> = List(size) { List(size) { 0 } }
        val timeInMs = timeExecution {
            var draftValue = 0
            items.forEach { i ->
                // this action is O(n)
                i.forEach { j ->
                    // this action is O(nˆ2)
                    draftValue++
                }
            }
        }
        showLog("Quadratic time execution: $timeInMs")
        return timeInMs
    }

    override suspend fun executeLogarithmic(): Long {
        val size = 1000
        val found = 500
        val items: List<Int> = MutableList(size) { 0 }

        val timeInMs = timeExecution {
            var low = 0
            var high = items.size - 1

            while (low <= high) {
                val mid = (low + high) / 2
                val guess = items[mid]

                when {
                    guess == found -> return@timeExecution
                    guess > found -> high = mid - 1
                    else -> low = mid + 1
                }
            }
        }

        showLog("Logarithmic time execution: $timeInMs")
        return timeInMs
    }

    override suspend fun executeExponential(): Long {
        val size = 1000
        val items: List<Int> = MutableList(size) { 0 }

        val timeInMs = timeExecution {
            // this action is O(2^n)
            val result = mutableListOf<List<Int>>()
            val n = items.size

            fun backtrack(start: Int, current: MutableList<Int>) {
                result.add(current.toList())
                for (i in start until n) {
                    current.add(items[i])
                    backtrack(i + 1, current)
                    current.removeAt(current.size - 1)
                }
            }

            backtrack(0, mutableListOf())
        }

        showLog("Exponential time execution: $timeInMs")
        return timeInMs
    }

    private fun showLog(message: String) {
        Log.i("LocalDataSourceImpl", message)
    }

    private suspend fun timeExecution(
        operation: () -> Unit
    ): Long {
        val startTime = SystemClock.elapsedRealtime()
        operation.invoke()
        val stopTime = SystemClock.elapsedRealtime()
        return (stopTime - startTime) / 1000000
    }
}
