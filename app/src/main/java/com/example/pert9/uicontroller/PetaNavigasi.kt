package com.example.pert9.uicontroller

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pert9.R
import com.example.pert9.uicontroller.DestinasiEntry
import com.example.pert9.uicontroller.DestinasiHome
import com.example.pert9.view.EntrySiswaScreen
import com.example.pert9.view.HomeScreen

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController()
) {
    HostNavigasi(navController = navController)
}

