package levkaantonov.com.study.composenavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import levkaantonov.com.study.composenavigation.ui.theme.ComposenavigationTheme

@ExperimentalMaterialApi
@Composable
fun AppContent() {
    ProvideWindowInsets {
        ComposenavigationTheme {
            val bottomNavItems =
                rememberSaveable { mutableStateOf<List<BottomNavItem>>(emptyList()) }
            //при выключении нижней панели приходится где нибудь включать((
            val showBottomNavBar =
                rememberSaveable { mutableStateOf(true) }
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    if (showBottomNavBar.value) {
                        BottomNavigationBar(
                            navController,
                            bottomNavItems.value
                        )
                    }
                }
            ) { paddingValues ->
                MainGraph(
                    bottomNavItems = bottomNavItems,
                    navController = navController,
                    showBottomNavBar = showBottomNavBar,
                    modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                )
            }
        }
    }
}