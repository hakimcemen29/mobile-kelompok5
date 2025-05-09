package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class HomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomePageScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(250.dp)
            ) {
                SidebarMenu()
            }
        },
        scrimColor = Color.Black.copy(alpha = 0.3f)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                // Kolom biru dengan rounded corner
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)) // Rounded corner
                        .background(Color(0xFF00AAFF))
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Intelegence Engineering",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                ObjectiveList()
            }
        }
    }
}

@Composable
fun ObjectiveList() {
    val items = listOf(
        "1. Merekam meaningful objectives yang telah ditetapkan pelaksana proyek. Paling tidak ada 4 objectives yaitu: organizational objectives, leading indicator, user outcomes, dan model properties.",
        "2. Merekam intelligence experience, yang paling tidak berisi (1) penyajian kecerdasan berupa satu atau lebih cara yaitu automate, prompt, organisation, dan atau annotate, (2) fungsi-fungsi yang dapat merealisasikan meaningful objectives; (3) bagaimana meminimalkan kesalahan perangkat lunak; (4) pengumpulan data untuk perbaikan perangkat lunak.",
        "3. Merekam intelligence implementation, yang paling tidak berisi proses bisnis perangkat lunak, teknologi yang akan dipakai dalam setiap proses, dan identifikasi proses yang akan menjadikan keseluruhan sistem yang dibangun menjadi cerdas.",
        "4. Merekam hal hal yang membatasi pengembangan modul Perangkat Lunak dan perekaman status realisasi modul Perangkat Lunak yang dikerjakan di aplikasi pengembangan modul Perangkat Lunak.",
        "5. Merekam perencanaan implementasi perangkat lunak, yang paling tidak menetapkan pelaksanaan deployment, pemeliharaan perangkat lunak, pelaksana operasi perangkat lunak."
    )
    Column {
        items.forEach { item ->
            Text(
                text = item,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
