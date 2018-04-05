package app.bluberryfox.showsinger.ui.singerinfo

import android.util.Log
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.util.Constants
import app.bluberryfox.showsinger.util.DataLoader
import app.bluberryfox.showsinger.util.saveSingerInfo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter(var activity: App, private var position: Int) : SingerInfoContract.Presenter {
    private var singerInfoView: SingerInfoContract.View? = null
    private val dataLoader = DataLoader()
//    private val networkManager = NetworkManager(context)

    override fun attachView(view: SingerInfoContract.View) {
        singerInfoView = view
        loadSingerInfo()
    }

    override fun detachView() {
        singerInfoView = null
    }

    override fun loadSingerInfo() {

        launch(UI) {
            val cachedSingerInfo = dataLoader.loadingSingersInfoFromCache(activity, position.toLong()).await()
            if (cachedSingerInfo!=null) {
                singerInfoView?.showSingerInfo(cachedSingerInfo)
                Log.d("INFO", cachedSingerInfo.toString())

            } else {
                val cloudSingersJob = dataLoader.loadSingerInfoAsync(Constants.URL, position-1)
                cloudSingersJob.start()
                val cloudSinger = cloudSingersJob.await()
                Log.d("INFO", cachedSingerInfo.toString())
                saveSingerInfo(activity, cloudSinger)
                val cachedSingerInfo = dataLoader.loadingSingersInfoFromCache(activity, position.toLong()).await()
                if (cachedSingerInfo!=null) {
                    Log.d("INFO", cachedSingerInfo.toString())

                }
                singerInfoView?.showSingerInfo(cloudSinger)


            }


        }
    }
}



