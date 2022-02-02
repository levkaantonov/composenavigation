package levkaantonov.com.study.composenavigation.extensions

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import levkaantonov.com.study.composenavigation.BottomNavItem
import levkaantonov.com.study.composenavigation.screens.FeatureApi

// экстеншен для регистрации фичи(читай экрана) в графе
fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navController: NavHostController,
    bottomNamItems: MutableState<List<BottomNavItem>>? = null,
    showBottomNavBar: MutableState<Boolean> = mutableStateOf(true),
    modifier: Modifier = Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        bottomNamItems = bottomNamItems,
        showBottomNavBar = showBottomNavBar,
        modifier = modifier
    )
}