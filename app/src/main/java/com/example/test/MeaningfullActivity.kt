package com.example.test

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import java.util.*

class MeaningfullActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeaningfullScreen()
        }
    }

    @Composable
    fun MeaningfullScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // Header with background and rounded corner
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
                    text = "Isi Form Ini untuk \nmembuat Tujuan",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Form Tujuan dan Tanggal
            Column(modifier = Modifier.padding(24.dp)) {
                Text("FORM ISIAN", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(16.dp))

                var organizationalObjectives by remember { mutableStateOf("") }
                var userOutcomes by remember { mutableStateOf("") }
                var leadingIndicator by remember { mutableStateOf("") }
                var modelProperties by remember { mutableStateOf("") }
                var startDate by remember { mutableStateOf("") }
                var endDate by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = organizationalObjectives,
                    onValueChange = { organizationalObjectives = it },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Organizational Objectives") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = userOutcomes,
                    onValueChange = { userOutcomes = it },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("User Outcomes") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = leadingIndicator,
                    onValueChange = { leadingIndicator = it },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Leading Indicator") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = modelProperties,
                    onValueChange = { modelProperties = it },
                    shape = RoundedCornerShape(12.dp),
                    label = { Text("Model Properties") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Row for Start Date and End Date
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Start Date Field
                    OutlinedTextField(
                        value = startDate,
                        onValueChange = { startDate = it },
                        label = { Text("Tanggal Mulai") },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        singleLine = true
                    )

                    // Calendar Icon for Start Date
                    IconButton(
                        onClick = { showDatePickerDialog(onDateSelected = { date ->
                            startDate = date
                        }) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_today),
                            contentDescription = "Calendar Icon"
                        )
                    }

                    // End Date Field
                    OutlinedTextField(
                        value = endDate,
                        onValueChange = { endDate = it },
                        label = { Text("Tanggal Akhir") },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        singleLine = true
                    )

                    // Calendar Icon for End Date
                    IconButton(
                        onClick = { showDatePickerDialog(onDateSelected = { date ->
                            endDate = date
                        }) },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_today),
                            contentDescription = "Calendar Icon"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        // TODO: Handle save action here
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A90E2)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Simpan", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    // Function to show the Date Picker Dialog
    private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "${selectedDayOfMonth}/${selectedMonth + 1}/$selectedYear"
                onDateSelected(selectedDate)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
}
