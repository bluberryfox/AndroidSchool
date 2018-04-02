package app.bluberryfox.showsinger.ui.singerinfo

import app.bluberryfox.showsinger.Constants
import app.bluberryfox.showsinger.network.DataLoader
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter:SingerInfoContract.Presenter{
    private var singerInfoView:SingerInfoContract.View? = null
    private val dataLoader= DataLoader()
    override fun attachView(view: SingerInfoContract.View) {
        singerInfoView = view
        loadSingerInfo()
    }

    override fun detachView() {
        singerInfoView = null
    }

    override fun loadSingerInfo() {
            launch(UI) {
                val job = dataLoader.loadSingerInfoAsync(Constants.URL)
                singerInfoView?.showSingerInfo(job.await())
            }
        }
    }


