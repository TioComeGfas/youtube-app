package cl.fredy.moncada.app.bigo.util

import android.app.Activity
import cl.fredy.moncada.app.bigo.BigOApplication

fun Activity.bigOApplication(): BigOApplication {
    return application as BigOApplication
}