package ru.wolfram.deep_link_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import ru.wolfram.deep_link_app.ui.theme.DeepLinkAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepLinkAppTheme {
                val navController = rememberNavController()
                val startDestination = Routes.Task1()
                val startDestinationCompanion = Routes.Task1
                val selectedDestination =
                    rememberSaveable { mutableIntStateOf(startDestinationCompanion.id) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                            NavigationBarItem(
                                selected = selectedDestination.intValue == Routes.Task1.id,
                                onClick = {
                                    navController.navigate(Routes.Task1())
                                    selectedDestination.intValue = Routes.Task1.id
                                },
                                icon = {},
                                label = {
                                    Text(Routes.Task1.label)
                                }
                            )
                            NavigationBarItem(
                                selected = selectedDestination.intValue == Routes.Task2.id,
                                onClick = {
                                    navController.navigate(Routes.Task2())
                                    selectedDestination.intValue = Routes.Task2.id
                                },
                                icon = {},
                                label = {
                                    Text(Routes.Task2.label)
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = startDestination,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Routes.Task1>(
                            deepLinks = listOf(
                                navDeepLink<Routes.Task1>(basePath = "${Routes.URL}/task1")
                            )
                        ) { entry ->
                            val route = entry.toRoute<Routes.Task1>()
                            Task1Screen(
                                pDefault = route.p.toIntOrNull(),
                                qDefault = route.q.toIntOrNull(),
                                nDefault = route.n.toLongOrNull()
                            )
                        }

                        composable<Routes.Task2>(
                            deepLinks = listOf(
                                navDeepLink<Routes.Task2>(basePath = "${Routes.URL}/task2")
                            )
                        ) { entry ->
                            val route = entry.toRoute<Routes.Task2>()
                        }
                    }
                }
            }
        }
    }
}