package com.example.test

import android.os.Bundle
import androidx.compose.material3.Text
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DataEntryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }

    @Composable
    fun LoginScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // Header dengan background biru dan lengkungan
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        color = Color(0xFF0099FF),
                        shape = RoundedCornerShape(bottomEnd = 100.dp)
                    )
            ) {
                Text(
                    text = "Selamat Datang\nKembali !",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Form Login
            Column(modifier = Modifier.padding(24.dp)) {
                Text("LOGIN\nFORM", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))

                var username by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation()
                )

                Text(
                    text = "Lupa kata sandi?",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 8.dp),
                    color = Color(0xFF4A90E2),
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* TODO: Aksi login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Masuk", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text("Belum punya akun?")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Daftar Sekarang.",
                        color = Color(0xFF4A90E2),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
