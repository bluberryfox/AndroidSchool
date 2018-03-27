package app.bluberryfox.showsinger.ui.singerinfo

/**
 * Created by user on 27.03.2018.
 */
class SingerInfoPresenter:SingerInfoContract.Presenter{
    private var singerInfoView:SingerInfoContract.View? = null
    override fun attachView(view: SingerInfoContract.View) {
        singerInfoView = view
        loadSingerInfo()
    }

    override fun detachView() {
        singerInfoView = null
    }

    override fun loadSingerInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}