package levkaantonov.com.study.composenavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import levkaantonov.com.study.composenavigation.extensions.register

@Composable
fun MainGraph(
    navController: NavHostController,
    bottomNavItems: MutableState<List<BottomNavItem>>,
    showBottomNavBar: MutableState<Boolean>,
    modifier: Modifier = Modifier,
) {
    val homeFeature = (LocalContext.current.applicationContext as App).homeFeature()
    val chatFeature = (LocalContext.current.applicationContext as App).chatsFeature()
    val lolFeature = (LocalContext.current.applicationContext as App).lolFeature()
    // регистрация главных экранов
    NavHost(
        navController = navController,
        startDestination = homeFeature.route()
    ) {
        register(
            homeFeature,
            navController = navController,
            bottomNamItems = bottomNavItems,
            showBottomNavBar = showBottomNavBar
        )
        register(
            chatFeature,
            navController = navController,
            bottomNamItems = bottomNavItems,
            showBottomNavBar = showBottomNavBar
        )
        register(
            lolFeature,
            navController = navController,
            showBottomNavBar = showBottomNavBar
        )
    }
}