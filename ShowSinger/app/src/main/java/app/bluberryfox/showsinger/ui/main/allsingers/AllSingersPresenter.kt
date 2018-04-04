package app.bluberryfox.showsinger.ui.main.allsingers

import android.content.Context
import app.bluberryfox.showsinger.util.Constants
import app.bluberryfox.showsinger.util.DataLoader
import app.bluberryfox.showsinger.util.NetworkManager
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class AllSingersPresenter(var context: Context) : AllSingersContract.Presenter {
    private var singerView: AllSingersContract.View? = null
    private val dataLoader = DataLoader()
    private val networkManager = NetworkManager(context)

    override fun loadSingers() {
        launch(UI) {
            if (networkManager.isConnectedToInternet == true) {
                val job = dataLoader.loadDataAsync(Constants.URL)
                singerView?.loadSingers(job.await())
                singerView?.hideProgress()
            } else {
                singerView?.showError()
            }
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