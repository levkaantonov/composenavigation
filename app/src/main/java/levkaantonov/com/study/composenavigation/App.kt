package levkaantonov.com.study.composenavigation

import android.app.Application
import levkaantonov.com.study.composenavigation.screens.chats.ChatsFeatureImpl
import levkaantonov.com.study.composenavigation.screens.home.HomeFeatureImpl
import levkaantonov.com.study.composenavigation.screens.lol.LolFeatureImpl


/*
 Типа Di)
 */
class App : Application() {
    fun homeFeature() = HomeFeatureImpl()
    fun chatsFeature() = ChatsFeatureImpl()
    fun lolFeature() = LolFeatureImpl()
}