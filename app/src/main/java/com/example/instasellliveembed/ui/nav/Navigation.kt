package com.example.instasellliveembed.ui.nav
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.instasellliveembed.ui.vm.LivestreamInfoViewModel
import com.example.instasellliveembed.ui.screens.InstasellLivestreamListScreen
import com.example.instasellliveembed.ui.screens.InstasellPlayerScreen
import com.example.instasellliveembed.util.Constants.Screens.INSTASELL_LIVESTREAM_LIST
import com.example.instasellliveembed.util.Constants.Screens.INSTASELL_VIDEO_PLAYER_SCREEN

sealed class Screens (val route: String){

    object InstasellLivestreamList: Screens(route = INSTASELL_LIVESTREAM_LIST)
    object InstasellVideoPlayer: Screens(route = "$INSTASELL_VIDEO_PLAYER_SCREEN/{livestreamId}"){
        fun createRoute(livestreamId: String): String {
            return "$INSTASELL_VIDEO_PLAYER_SCREEN/$livestreamId"
        }
    }

}

@Composable
fun SetupNavHost(navController: NavHostController, livestreamInfoViewModel: LivestreamInfoViewModel) {

    NavHost(navController = navController, startDestination = Screens.InstasellLivestreamList.route) {

        composable(route = Screens.InstasellLivestreamList.route) {
            InstasellLivestreamListScreen(livestreamInfoViewModel = livestreamInfoViewModel, navController = navController)
        }

        composable(
            Screens.InstasellVideoPlayer.route,
            arguments = listOf(navArgument("livestreamId") { type = NavType.StringType })
        ) { backStackEntry ->
            InstasellPlayerScreen(
                livestreamId = backStackEntry.arguments?.getString("livestreamId") ?: "",
                navController = navController
            )
        }

    }

}