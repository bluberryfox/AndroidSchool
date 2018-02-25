package csu.iit.ru.showsinger.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import csu.iit.ru.showsinger.R

/**
 * Created by user on 22.02.2018.
 */
class SingerInfo: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.singer_info, container, false)
    }
}