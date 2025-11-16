package com.example.studentapp_mobcom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp_mobcom.ui.theme.StudentAppMobcomTheme

@Composable
fun BerandaScreen() {
    // Column agar bisa di-scroll
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                top = 48.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Hello, Aulia!",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Kamu punya 3 tugas yang perlu diselesaikan",
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.Notifications,
                contentDescription = "Notifikasi",
                tint = Color(0xFFCD29).copy(alpha = 1f),
                modifier = Modifier.size(42.dp)
            )
        }

        // Card 1: Progress Keseluruhan
        Card(modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp,
                color = Color(0xC5C5C5).copy(alpha = 1f),
                shape = RoundedCornerShape(12.dp)
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.TaskAlt,
                        contentDescription = null,
                        tint = Color(0x14AE5C).copy(alpha = 1f),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Progress Keseluruhan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                        )
                }
                Spacer(modifier = Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { 0.7f },
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0x00000).copy(alpha = 1f),
                )
                Row (modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Text("7 dari 10 tugas selesai",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text("70%",
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp)
                }
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("7",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0x14AE5C).copy(alpha = 1f)
                        )
                        Text("Selesai")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("2",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0x0088FF).copy(alpha = 1f)
                        )
                        Text("Dikerjakan")
                    }
                    Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                        Text("1",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp,
                            color = Color(0xFF383C).copy(alpha = 1f)
                        )
                        Text("Selesai")
                    }
                }
            }
        }

        // Card 2: Notifikasi Penting
        Card(modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp,
                color = Color(0xC5C5C5).copy(alpha = 1f),
                shape = RoundedCornerShape(12.dp)
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.WarningAmber,
                        contentDescription = null,
                        tint = Color(0xFFCD29).copy(alpha = 1f),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Notifikasi Penting",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFCC7C7).copy(alpha = 0.39f))) {
                    Row(modifier = Modifier.padding(12.dp)) {
                        Icon(Icons.Default.Alarm,
                            contentDescription = null,
                            tint = Color(0xDC362E).copy(alpha = 1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                "Deadline Mendekati",
                                fontWeight = FontWeight.Bold,
                                color = Color(0xDC362E).copy(alpha = 1f),
                                fontSize = 16.sp
                            )
                            Text(
                                "Tugas 3 Machine Learning harus dikumpulkan dalam 1 hari",
                                color = Color(0xB3241E).copy(alpha = 1f),
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
                // ... (Tambahkan Card biru di bawahnya)
            }
        }

        // Card 3: Tugas Mendatang
        Card(modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp,
                color = Color(0xC5C5C5).copy(alpha = 1f),
                shape = RoundedCornerShape(12.dp)
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Task,
                        contentDescription = null,
                        tint = Color(0x0088FF).copy(alpha = 1f),
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Tugas Mendatang",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xD6CACA).copy(alpha = 0.2f)
                    ),) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Tugas 3 RDF",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Semantik Web",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                        // "Chip" untuk prioritas
                        Column() {
                            SuggestionChip(
                                onClick = { /*TODO*/ },
                                label = { Text("Tinggi",
                                    color = Color(0xFFFFFF).copy(alpha = 1f),
                                ) },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = Color(0xC00F0C).copy(alpha = 1f)
                                ),
                                border = BorderStroke(
                                    color = Color(0xC00F0C).copy(alpha = 1f),
                                    width = 1.dp
                                )
                            )
                            Text("1 Hari Lagi",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xD6CACA).copy(alpha = 0.2f)
                    ),) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Tugas Android Studio",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "Mobile Computing",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                        // "Chip" untuk prioritas
                        Column() {
                            SuggestionChip(
                                onClick = { /*TODO*/ },
                                label = { Text("Sedang",
                                    color = Color(0xFFFFFF).copy(alpha = 1f),
                                ) },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = Color(0xFFCD29).copy(alpha = 0.9f)
                                ),
                                border = BorderStroke(
                                    color = Color(0xFFCD29).copy(alpha = 1f),
                                    width = 1.dp
                                )
                            )
                            Text("2 Hari Lagi",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xD6CACA).copy(alpha = 0.2f)
                    ),) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Tugas Artikel Final",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = "JKKD",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }
                        // "Chip" untuk prioritas
                        Column() {
                            SuggestionChip(
                                onClick = { /*TODO*/ },
                                label = { Text("Rendah",
                                    color = Color(0xFFFFFF).copy(alpha = 1f),
                                ) },
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = Color(0x30D158).copy(alpha = 0.9f)
                                ),
                                border = BorderStroke(
                                    color = Color(0xFFCD29).copy(alpha = 1f),
                                    width = 1.dp
                                )
                            )
                            Text("3 Hari Lagi",
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            )
                        }

                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BerandaScreenPreview() {
    // Pastikan Anda menggunakan tema aplikasi Anda
    // agar preview-nya akurat (sesuai file Theme.kt)
    StudentAppMobcomTheme {
        BerandaScreen()
    }
}