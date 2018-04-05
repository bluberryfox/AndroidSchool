package app.bluberryfox.showsinger.ui.singerinfo

import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.util.Constants
import app.bluberryfox.showsinger.util.loadSingerInfoAsync
import app.bluberryfox.showsinger.util.loadingSingersInfoFromCache
import app.bluberryfox.showsinger.util.saveSingerInfo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter(var activity: App, private var position: Int) : SingerInfoContract.Presenter {
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
            val cachedSingerInfo = loadingSingersInfoFromCache(activity, position.toLong()).await()
            if (cachedSingerInfo!=null) {
                singerInfoView?.showSingerInfo(cachedSingerInfo)

            } else {
                val cloudSingersJob = loadSingerInfoAsync(Constants.URL, position-1)
                cloudSingersJob.start()
                val cloudSinger = cloudSingersJob.await()
                saveSingerInfo(activity, cloudSinger)
                singerInfoView?.showSingerInfo(cloudSinger)


            }


        }
    }
}



