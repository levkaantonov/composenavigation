package levkaantonov.com.study.composenavigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsHeight

typealias Action = () -> Unit

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val action: Action? = null
)

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    navController: NavController,
    tabs: List<BottomNavItem>,
) {
    if (tabs.isEmpty()) {
        return
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: tabs.first().route

    BottomNavigation(
        modifier = Modifier.navigationBarsHeight(additional = 56.dp)
    ) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                label = {
                    Text(tab.name)
                },
                icon = { },
                selected = currentRoute == tab.route,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.LightGray,
                onClick = {
                    if (tab.action != null) {
                        tab.action.invoke()
                        return@BottomNavigationItem
                    }
                    if (tab.route != currentRoute) {
                        navController.navigate(tab.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                }
            )
        }
    }
}