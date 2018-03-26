package app.bluberryfox.showsinger

/**
 * Created by user on 27.03.2018.
 */
interface BasePresenter<in T> {
    fun attachView(view: T)
    fun detachView()
}