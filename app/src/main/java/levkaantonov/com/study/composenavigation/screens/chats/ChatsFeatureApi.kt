package levkaantonov.com.study.composenavigation.screens.chats

import levkaantonov.com.study.composenavigation.screens.FeatureApi

interface ChatsFeatureApi : FeatureApi {
    fun route(): String
}