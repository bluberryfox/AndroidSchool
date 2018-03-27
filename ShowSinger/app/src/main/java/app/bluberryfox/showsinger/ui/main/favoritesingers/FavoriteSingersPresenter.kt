package app.bluberryfox.showsinger.ui.main.favoritesingers

/**
 * Created by user on 27.03.2018.
 */
class FavoriteSingersPresenter : FavoriteSingersContract.Presenter {
    private var singerView: FavoriteSingersContract.View? = null
    override fun attachView(view: FavoriteSingersContract.View) {
        singerView = view
    }

    override fun detachView() {
        singerView = null
    }

}