package app.bluberryfox.showsinger.ui.main.favoritesingers

import android.content.Context
import app.bluberryfox.showsinger.App
import app.bluberryfox.showsinger.data.Singer
import app.bluberryfox.showsinger.util.selectSpecial
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by user on 27.03.2018.
 */
class FavoriteSingersPresenter(var context: Context, var activity: App) : FavoriteSingersContract.Presenter {
    private var singerView: FavoriteSingersContract.View? = null
    override fun loadFavoriteSingers() {
        val favoriteSingers = Singer.List()
        launch(UI) {
            val savedSingers = selectSpecial(activity, 1).await()
            if(favoriteSingers.isNotEmpty()){
                favoriteSingers.addAll(savedSingers)
            }
            singerView?.showFavoriteSingers(favoriteSingers)

        }
    }

    override fun attachView(view: FavoriteSingersContract.View) {
        singerView = view
        loadFavoriteSingers()
    }

    override fun detachView() {
        singerView = null
    }

}