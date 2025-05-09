package com.example.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SidebarMenu() {
    Column(
            modifier = Modifier
                    .width(200.dp)
                    .fillMaxHeight()
                    .background(Color(0xFF007AFF))
                    .padding(16.dp)
    ) {
        Text("Menu Utama", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(12.dp))
        MenuItem("Home")
        MenuItem("Projek")
        MenuItem("Meaningful Objectives")
        MenuItem("Intelligence Experience")
        MenuItem("Intelligence Implementation")
        MenuItem("Batasan Pengembangan")
        MenuItem("Status Realisasi")
        MenuItem("Perencanaan")
        Spacer(modifier = Modifier.weight(1f))
        Button(
                onClick = { /* handle logout */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(8.dp)
        ) {
            Text("LOG OUT", color = Color.White)
        }
    }
}

@Composable
fun MenuItem(title: String) {
    Text(
            text = title,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
    )
}
