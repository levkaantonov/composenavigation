package levkaantonov.com.study.composenavigation.screens.lol

import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import levkaantonov.com.study.composenavigation.BottomNavItem

class LolFeatureImpl : LolFeatureApi {
    private val baseRoute: String = "lol"

    override fun route(): String {
        return baseRoute
    }

    override fun navBarItems(): List<BottomNavItem> {
        return emptyList()
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        bottomNamItems: MutableState<List<BottomNavItem>>?,
        showBottomNavBar: MutableState<Boolean>,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            LolScreen(modifier = modifier, navController = navController)
        }
    }
}