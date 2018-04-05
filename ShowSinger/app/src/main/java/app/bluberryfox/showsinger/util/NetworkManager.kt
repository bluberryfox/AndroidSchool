package app.bluberryfox.showsinger.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager(var context:Context) {
    public val isConnectedToInternet: Boolean?
        get() {
            val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectManager.activeNetworkInfo
            return info != null && info.isConnected
        }

}