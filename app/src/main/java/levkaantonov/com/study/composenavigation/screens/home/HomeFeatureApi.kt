package levkaantonov.com.study.composenavigation.screens.home

import levkaantonov.com.study.composenavigation.screens.FeatureApi

interface HomeFeatureApi : FeatureApi {
    fun route(): String
}