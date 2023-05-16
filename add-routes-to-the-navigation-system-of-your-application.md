---
description: >-
  Adding the route and screen to display all the active, upcoming and previous
  livestreams
---

# Add routes to the navigation system of your application

Register the following routes in the existing navigation system of your app. In the example app, the navigation is defined in `app/src/main/java/com/example/instasellliveembed/ui/nav/Navigation.kt`

````kotlin
```kotlin
// You do not need to add the whole file. Incase you already have a navigation system in place just register these screens as well.
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

// this where the screen class defined to assist in typing screen name
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
        
        // adding the livestream list screen
        composable(route = Screens.InstasellLivestreamList.route) {
            InstasellLivestreamListScreen(livestreamInfoViewModel = livestreamInfoViewModel, navController = navController)
        }
        
        // adding the video player screen
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
```
````



