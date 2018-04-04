package app.bluberryfox.showsinger.ui.singerinfo

import android.content.Context
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.SingerInfo
import app.bluberryfox.showsinger.util.Constants
import app.bluberryfox.showsinger.util.DataLoader
import app.bluberryfox.showsinger.util.NetworkManager
import app.bluberryfox.showsinger.util.saveSingerInfo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter(var context: Context, var activity: App, var position: Int) : SingerInfoContract.Presenter {
    private var singerInfoView: SingerInfoContract.View? = null
    private val dataLoader = DataLoader()
    private val networkManager = NetworkManager(context)

    override fun attachView(view: SingerInfoContract.View) {
        singerInfoView = view
        loadSingerInfo()
    }

    override fun detachView() {
        singerInfoView = null
    }

    override fun loadSingerInfo() {
        var singerInfo = SingerInfo(0, "", "")
        launch(UI) {
            val cachedSingerInfo = dataLoader.loadingSingersInfoFromCache(activity, position).await()
            val cachedSingersInfo = dataLoader.loadingSingersFromCache(activity).await()
            if (cachedSingersInfo.isNotEmpty()) {
                singerInfo = cachedSingerInfo!!

            } else {
                val cloudSingersJob = dataLoader.loadSingerInfoAsync(Constants.URL, position)
                cloudSingersJob.start()
                val cloudSinger = cloudSingersJob.await()
                saveSingerInfo(activity, cloudSinger)
                singerInfo = cloudSinger

            }
            singerInfoView?.showSingerInfo(singerInfo)

        }
    }
}



