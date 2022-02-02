package levkaantonov.com.study.composenavigation.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import levkaantonov.com.study.composenavigation.BottomNavItem

interface FeatureApi {
    fun navBarItems(): List<BottomNavItem>

    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        bottomNamItems: MutableState<List<BottomNavItem>>? = null,
        showBottomNavBar: MutableState<Boolean>,
        modifier: Modifier = Modifier
    )
}