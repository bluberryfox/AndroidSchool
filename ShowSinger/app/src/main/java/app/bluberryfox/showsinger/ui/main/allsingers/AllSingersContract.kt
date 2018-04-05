package app.bluberryfox.showsinger.ui.main.allsingers

import app.bluberryfox.showsinger.BasePresenter
import app.bluberryfox.showsinger.BaseView
import app.bluberryfox.showsinger.data.Singer

/**
 * Created by user on 27.03.2018.
 */
interface AllSingersContract{
    interface View: BaseView<Presenter> {
        fun showSingers(singers: Singer.List)
        fun showSingerInfo(singer:Singer)
        fun showError()
    }
    interface Presenter:BasePresenter<View>{
        fun loadSingers()

    }
}