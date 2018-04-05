package app.bluberryfox.showsinger.ui.main.favoritesingers

import app.bluberryfox.showsinger.BasePresenter
import app.bluberryfox.showsinger.BaseView
import app.bluberryfox.showsinger.data.Singer

/**
 * Created by user on 27.03.2018.
 */
interface FavoriteSingersContract{
    interface View: BaseView<Presenter> {
        fun showFavoriteSingers(singers: Singer.List)
        fun showSingerInfo(singer:Singer)
    }
    interface Presenter:BasePresenter<View>{
        fun loadFavoriteSingers()
    }
}