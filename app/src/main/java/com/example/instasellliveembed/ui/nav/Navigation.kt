package com.example.instasellliveembed.ui.nav
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.instasellliveembed.ui.vm.LivestreamInfoViewModel
import com.example.instasellliveembed.ui.screens.HomeScreen
import com.example.instasellliveembed.ui.screens.PlayerWebViewScreen
import com.example.instasellliveembed.util.Constants.Screens.VIDEO_PLAYER_SCREEN
import com.example.instasellliveembed.util.Constants.Screens.HOME_SCREEN

sealed class Screens (val route: String){

    object Home: Screens(route = HOME_SCREEN)
    object VideoPlayer: Screens(route = "$VIDEO_PLAYER_SCREEN/{livestreamId}"){
        fun createRoute(livestreamId: String): String {
            return "$VIDEO_PLAYER_SCREEN/$livestreamId"
        }
    }

}

@Composable
fun SetupNavHost(navController: NavHostController, livestreamInfoViewModel: LivestreamInfoViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(livestreamInfoViewModel = livestreamInfoViewModel, navController = navController)
        }

        composable(
            Screens.VideoPlayer.route,
            arguments = listOf(navArgument("livestreamId") { type = NavType.StringType })
        ) { backStackEntry ->
            PlayerWebViewScreen(
                livestreamId = backStackEntry.arguments?.getString("livestreamId") ?: "",
                navController = navController
            )
        }

    }

}