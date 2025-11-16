package com.example.studentapp_mobcom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChecklistRtl
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.compose.ui.Alignment
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.ui.draw.rotate
import com.example.studentapp_mobcom.ui.theme.StudentAppMobcomTheme

// Definisikan screen-screen Anda
sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Beranda : Screen("beranda", "Beranda", Icons.Default.Home)
    object Tugas : Screen("tugas", "Tugas", Icons.Default.ChecklistRtl)
    object Kalender : Screen("kalender", "Kalender", Icons.Default.CalendarToday)
    object Profil : Screen("profil", "Profil", Icons.Default.Person)

    // Ini bukan di bottom bar, tapi screen terpisah
    object TambahTugas : Screen("tambah_tugas", "Tambah Tugas", Icons.Default.Add)
}

val items = listOf(Screen.Beranda, Screen.Tugas, Screen.Kalender, Screen.Profil)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentAppMobcomTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var isFabRotated by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (isFabRotated) 45f else 0f,
        label = "fabRotation"
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (currentDestination?.route == Screen.TambahTugas.route) {
                        navController.navigate(Screen.Beranda.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                        isFabRotated = false
                    } else {
                        navController.navigate(Screen.TambahTugas.route)
                        isFabRotated = true
                    }
                },
                shape = RoundedCornerShape(200.dp),
                containerColor = Color(0xFF3F51B5),
                modifier = Modifier
                    .offset(y = 75.dp)
                    .size(65.dp)
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Tambah Tugas",
                    tint = Color.White,
                    modifier = Modifier
                        .size(52.dp)
                        .rotate(rotation)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

        bottomBar = {
            BottomAppBar(
                actions = {
                    // Item Beranda
                    NavigationBarItem(
                        modifier = Modifier.weight(1f),
                        selected = currentDestination?.route == Screen.Beranda.route,
                        onClick = {
                            navController.navigate(Screen.Beranda.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Screen.Beranda.icon, contentDescription = Screen.Beranda.label) },
                        label = { Text(Screen.Beranda.label) }
                    )

                    // Item Tugas
                    NavigationBarItem(
                        selected = currentDestination?.route == Screen.Tugas.route,
                        onClick = {
                            navController.navigate(Screen.Tugas.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Screen.Tugas.icon, contentDescription = Screen.Tugas.label) },
                        label = { Text(Screen.Tugas.label) }
                    )

                    Spacer(modifier = Modifier.weight(1.2f))

                    // Item Kalender
                    NavigationBarItem(
                        selected = currentDestination?.route == Screen.Kalender.route,
                        onClick = {
                            navController.navigate(Screen.Kalender.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Screen.Kalender.icon, contentDescription = Screen.Kalender.label) },
                        label = { Text(Screen.Kalender.label) }
                    )

                    // Item Profil
                    NavigationBarItem(
                        selected = currentDestination?.route == Screen.Profil.route,
                        onClick = {
                            navController.navigate(Screen.Profil.route) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = { Icon(Screen.Profil.icon, contentDescription = Screen.Profil.label) },
                        label = { Text(Screen.Profil.label) }
                    )
                },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            NavHost(navController = navController, startDestination = Screen.Beranda.route) {
                composable(Screen.Beranda.route) { BerandaScreen() }
                composable(Screen.Tugas.route) { DaftarTugasScreen() }
                composable(Screen.TambahTugas.route) { TambahTugasScreen() }

                composable(Screen.Kalender.route) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Halaman Kalender")
                    }
                }
                composable(Screen.Profil.route) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Halaman Profil")
                    }
                }
            }
        }
    }
}