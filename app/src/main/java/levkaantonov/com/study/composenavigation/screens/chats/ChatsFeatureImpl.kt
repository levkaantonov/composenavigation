package levkaantonov.com.study.composenavigation.screens.chats

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import levkaantonov.com.study.composenavigation.BottomNavItem
import levkaantonov.com.study.composenavigation.screens.chats.internal_screens.InternalChatsFeatureImp
import kotlin.random.Random

class ChatsFeatureImpl : ChatsFeatureApi {

    private val baseRoute = "chats"
    private val internalChatsFeatureImp = InternalChatsFeatureImp(baseRoute = baseRoute)

    override fun route(): String {
        return baseRoute
    }

    override fun navBarItems(): List<BottomNavItem> {
        return listOf(
            BottomNavItem(
                name = "Chats",
                route = "$baseRoute/$baseRoute",
                icon = Icons.Default.Notifications
            ),
            BottomNavItem(
                name = "Msg",
                route = internalChatsFeatureImp.messagesRoute(),
                icon = Icons.Default.Email
            ),
            BottomNavItem(
                name = "Groups",
                route = internalChatsFeatureImp.groupsRoute(),
                icon = Icons.Default.Notifications
            ),
            BottomNavItem(
                name = "Settings",
                route = internalChatsFeatureImp.settingsRoute(Random.nextInt(100).toString()),
                icon = Icons.Default.Settings
            )
        )
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        bottomNamItems: MutableState<List<BottomNavItem>>?,
        showBottomNavBar: MutableState<Boolean>,
        modifier: Modifier
    ) {
        navGraphBuilder.navigation(
            route = baseRoute,
            startDestination = "$baseRoute/$baseRoute"
        ) {
            composable("$baseRoute/$baseRoute") {
                bottomNamItems?.value = navBarItems()
                ChatsScreen(navController = navController)
            }

            internalChatsFeatureImp.registerGraph(
                navGraphBuilder = navGraphBuilder,
                navController = navController,
                showBottomNavBar = showBottomNavBar,
                modifier = modifier
            )
        }
    }
}