package app.bluberryfox.showsinger.ui.main.favoritesingers

import app.bluberryfox.showsinger.BasePresenter
import app.bluberryfox.showsinger.BaseView

/**
 * Created by user on 27.03.2018.
 */
interface FavoriteSingersContract{
    interface View: BaseView<Presenter> {
    }
    interface Presenter:BasePresenter<View>{
    }
}