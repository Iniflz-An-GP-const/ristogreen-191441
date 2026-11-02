package d7man.ristogreen.digital.ui.composable.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import d7man.ristogreen.digital.data.model.PuzzleLevel
import d7man.ristogreen.digital.ui.composable.screen.about.DIRILAboutScreen
import d7man.ristogreen.digital.ui.composable.screen.game.DIRILGameScreen
import d7man.ristogreen.digital.ui.composable.screen.game_records.DIRILGameRecordsScreen
import d7man.ristogreen.digital.ui.composable.screen.main_menu.DIRILMainMenuScreen
import d7man.ristogreen.digital.ui.composable.screen.puzzle_setup.DIRILPuzzleSetupScreen
import d7man.ristogreen.digital.ui.composable.screen.splash.DIRILSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val activity = LocalActivity.current

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            DIRILSplashScreen(
                onMainMenuScreenNavigation = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.MainMenu> {
            DIRILMainMenuScreen(
                onPuzzleSelectionScreenNavigation = { navController.navigate(route = NavRoute.PuzzleSetup) },
                onGameRecordsScreenNavigation = { navController.navigate(route = NavRoute.GameRecords) },
                onAboutScreenNavigation = { navController.navigate(route = NavRoute.About) },
                onExit = { activity?.finishAffinity() }
            )
        }

        composable<NavRoute.PuzzleSetup> {
            DIRILPuzzleSetupScreen(
                onStartGame = { puzzleId, level ->
                    navController.navigate(
                        route = NavRoute.Game(
                            puzzleId = puzzleId,
                            level = level.name,
                        )
                    )
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavRoute.Game> { backStackEntry ->
            val gameRoute: NavRoute.Game = backStackEntry.toRoute()
            DIRILGameScreen(
                puzzleId = gameRoute.puzzleId,
                level = PuzzleLevel.valueOf(gameRoute.level),
                onExitToMainMenu = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.About> {
            DIRILAboutScreen(onBackClick = { navController.popBackStack() })
        }

        composable<NavRoute.GameRecords> {
            DIRILGameRecordsScreen(onBackClick = { navController.popBackStack() })
        }
    }
}