package app.bluberryfox.showsinger.ui.main.allsingers

import android.content.Context
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.util.Constants
import app.bluberryfox.showsinger.util.DataLoader
import app.bluberryfox.showsinger.util.NetworkManager
import app.bluberryfox.showsinger.util.saveSingers
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class AllSingersPresenter(var context: Context, var activity:App) : AllSingersContract.Presenter {
    private var singerView: AllSingersContract.View? = null
    private val dataLoader = DataLoader()
    private val networkManager = NetworkManager(context)

    override fun loadSingers() {
        var singers = Singer.List()
        launch(UI) {
            val cachedSingers = dataLoader.loadingSingersFromCache(activity).await()
            if(cachedSingers.isNotEmpty()){
                singers.addAll(cachedSingers)

            } else {
                val cloudSingersJob = dataLoader.loadDataAsync(Constants.URL)
                cloudSingersJob.start()
                val cloudSingers = cloudSingersJob.await()
                saveSingers( activity, cloudSingers)
                singers.addAll(cloudSingers)

            }
            singerView?.loadSingers(singers)

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