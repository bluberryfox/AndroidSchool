package app.bluberryfox.showsinger.ui.singerinfo

import app.bluberryfox.showsinger.BasePresenter
import app.bluberryfox.showsinger.BaseView

/**
 * Created by user on 27.03.2018.
 */
interface SingerInfoContract{
    interface View:BaseView<Presenter>{
        fun showProgress()

    }
    interface Presenter:BasePresenter<View>{
        fun loadSingerInfo()

    }
}
