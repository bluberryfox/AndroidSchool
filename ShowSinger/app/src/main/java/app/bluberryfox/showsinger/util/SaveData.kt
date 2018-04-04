package app.bluberryfox.showsinger.util

import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.Singer
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import kotlin.coroutines.experimental.CoroutineContext

fun saveSingers(
        app: App,
        singers: List<Singer>,
        coroutineContext: CoroutineContext = CommonPool
): Deferred<Unit> = async(coroutineContext) {
    app.database.singersDao().unsertAll(singers)
}