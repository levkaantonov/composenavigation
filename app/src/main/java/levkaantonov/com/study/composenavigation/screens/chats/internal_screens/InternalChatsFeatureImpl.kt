package levkaantonov.com.study.composenavigation.screens.chats.internal_screens

import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import levkaantonov.com.study.composenavigation.BottomNavItem
import levkaantonov.com.study.composenavigation.screens.FeatureApi
import levkaantonov.com.study.composenavigation.screens.chats.internal_screens.groups.GroupsScreen
import levkaantonov.com.study.composenavigation.screens.chats.internal_screens.messages.MessagesScreen
import levkaantonov.com.study.composenavigation.screens.chats.internal_screens.settings.SettingsScreen

/*
   Реализация вложенных экранов для chatsFeature.
 */
class InternalChatsFeatureImp(baseRoute: String) : FeatureApi {
    private val graphRoute = "$baseRoute/nested"

    private val groupsRoute = "$baseRoute/groups"

    private val messagesRoute = "$baseRoute/messages"

    private val settingsRoute = "$baseRoute/settings"
    private val paramOneKey = "SMILE"

    fun groupsRoute(): String {
        return groupsRoute
    }

    fun messagesRoute(): String {
        return messagesRoute
    }

    fun settingsRoute(param: String): String {
        return "$settingsRoute/${param}"
    }

    fun baseRoute(): String {
        return graphRoute
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
        navGraphBuilder.navigation(
            route = graphRoute,
            startDestination = messagesRoute
        ) {
            composable(route = groupsRoute) {
                GroupsScreen(navController = navController)
            }
            composable(route = messagesRoute) {
                showBottomNavBar.value = true
                MessagesScreen(navController = navController)

            }
            composable(
                route = "$settingsRoute/{$paramOneKey}",
                arguments = listOf(navArgument(paramOneKey) {
                    type = NavType.StringType
                    defaultValue = "#"
                })
            ) {
                showBottomNavBar.value = false
                val arguments = requireNotNull(it.arguments)
                val argument = arguments.getString(paramOneKey)
                SettingsScreen(
                    modifier = modifier,
                    navController = navController,
                    param = argument.orEmpty(),
                    navigateToMsg = {
                        messagesRoute()
                    }
                )
            }
        }
    }
}