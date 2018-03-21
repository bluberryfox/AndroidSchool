package app.bluberryfox.showsinger.anko

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import app.bluberryfox.showsinger.R
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by user on 14.03.2018.
 */
class SingerInfoUI(context: Context):_LinearLayout(context){
    init{
        orientation =LinearLayout.VERTICAL
        lparams(width=matchParent, height = matchParent)
        ankoView(::ToolbarUI, 0){
        }.lparams(width = matchParent, height= wrapContent)
        imageView{
            id = R.id.imageView
            scaleType = ImageView.ScaleType.FIT_XY
        }.lparams(width = matchParent, height = dip(463)){
//            android:layout_alignParentLeft="true"
//            android:layout_alignParentTop="true"
        }
        textView("Самая популярная песня"){
            id = R.id.singerName
        }.lparams(width= matchParent, height = wrapContent){
            topMargin = dip (10)
            leftMargin = dip(3)
        }
        textView("Самая популярная песня"){
            id= R.id.popularSong
        }.lparams(width= matchParent, height = wrapContent){
            topMargin = dip (10)
            leftMargin = dip(3)
        }
        textView("Самый популярный альбом"){
            id = R.id.popularAlbum
        }.lparams(width = matchParent, height = wrapContent){
            leftMargin = dip(3)
            topMargin = dip (10)
        }
    }
}