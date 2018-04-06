package app.bluberryfox.showsinger.ui.singerinfo

import android.content.Context
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.util.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter(var context: Context, var activity: App, private var position: Int) : SingerInfoContract.Presenter {
    private var networkManager = NetworkManager(context)

    override fun saveToFavorite(id: Int) {
        launch(UI) {
            saveSingerToFavorite(activity, id.toLong())
        }
    }

    private var singerInfoView: SingerInfoContract.View? = null

    override fun attachView(view: SingerInfoContract.View) {
        singerInfoView = view
        loadSingerInfo()
    }

    override fun detachView() {
        singerInfoView = null
    }

    override fun loadSingerInfo() {
        launch(UI) {
            if (networkManager.isConnectedToInternet == false) {
                val cachedSingerInfo = loadingSingersInfoFromCache(activity, position.toLong()).await()
                if (cachedSingerInfo != null) {
                    singerInfoView?.showSingerInfo(cachedSingerInfo)
                }
            } else {
                val cloudSingersJob = loadSingerInfo(Constants.URL, position - 1)
                cloudSingersJob.start()
                val cloudSinger = cloudSingersJob.await()
                saveSingerInfo(activity, cloudSinger)
                singerInfoView?.showSingerInfo(cloudSinger)
            }
        }
    }
}



