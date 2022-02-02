package levkaantonov.com.study.composenavigation.screens.chats.internal_screens.groups

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import levkaantonov.com.study.composenavigation.App

@Composable
fun GroupsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val homeFeature = (LocalContext.current.applicationContext as App).homeFeature()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Groups",
            color = Color.Magenta,
            fontWeight = FontWeight.Bold,
            fontSize = 100.sp
        )

        Button(
            shape = RoundedCornerShape(25.dp),
            onClick = {
                navController.popBackStack()
                navController.navigate(homeFeature.route())
            },
        ) {
            Text(
                text = "To Home",
                color = Color.Magenta,
                fontWeight = FontWeight.SemiBold,
                fontSize = 35.sp
            )
        }
    }
}

@Preview
@Composable
fun GroupsScreenPreview() {
    GroupsScreen(navController = rememberNavController())
}