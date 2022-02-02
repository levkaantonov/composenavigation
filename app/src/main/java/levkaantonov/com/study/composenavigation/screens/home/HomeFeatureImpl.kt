package levkaantonov.com.study.composenavigation.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import levkaantonov.com.study.composenavigation.BottomNavItem

class HomeFeatureImpl : HomeFeatureApi {

    private val baseRoute = "home"

    override fun route(): String {
        return baseRoute
    }

    override fun navBarItems(): List<BottomNavItem> {
        return listOf(
            BottomNavItem(name = "Home", route = "home", icon = Icons.Default.Home),
            BottomNavItem(name = "Chats", route = "chats", icon = Icons.Default.AccountBox),
            BottomNavItem(name = "Lol", route = "lol", icon = Icons.Default.AccountBox)
        )
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        bottomNamItems: MutableState<List<BottomNavItem>>?,
        showBottomNavBar: MutableState<Boolean>,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            bottomNamItems?.value = navBarItems()
            HomeScreen(modifier = modifier, navController = navController)
        }
    }
}