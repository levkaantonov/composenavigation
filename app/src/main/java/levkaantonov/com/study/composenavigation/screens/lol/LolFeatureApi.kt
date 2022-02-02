package levkaantonov.com.study.composenavigation.screens.lol

import levkaantonov.com.study.composenavigation.screens.FeatureApi

interface LolFeatureApi : FeatureApi {
    fun route(): String
}