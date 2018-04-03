package app.bluberryfox.showsinger.ui.main.allsingers

import app.bluberryfox.showsinger.Constants
import app.bluberryfox.showsinger.network.DataLoader
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class AllSingersPresenter:AllSingersContract.Presenter{
    private var singerView:AllSingersContract.View? = null
    private val dataLoader= DataLoader()
    override fun loadSingers() {
        launch(UI) {
            val job = dataLoader.loadDataAsync(Constants.URL)
            singerView?.loadSingers(job.await())
        }
    }
    override fun detachView() {
        singerView = null
    }

    override fun attachView(view: AllSingersContract.View) {
        singerView = view
        loadSingers()
    }


}