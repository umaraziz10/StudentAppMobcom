package com.example.studentapp_mobcom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarTugasScreen() {
    // Data dummy untuk list
    val daftarTugas = listOf("Tugas 3 RDF", "Title", "Title", "Title")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 48.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp),
    ) {
        Text(text = "Daftar Tugas",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Cari tugas atau mata kuliah...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Filter Chips
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text("Mata Kuliah")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.Black
                    )
                },
                shape = RoundedCornerShape(50),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.White,
                    labelColor = Color.Black,
                    iconColor = Color.Black
                ),
                border = BorderStroke(
                    1.dp,
                    Color.LightGray.copy(alpha = 0.6f)
                )
            )
            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text("Status")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.Black
                    )
                },
                shape = RoundedCornerShape(50),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.White,
                    labelColor = Color.Black,
                    iconColor = Color.Black
                ),
                border = BorderStroke(
                    1.dp,
                    Color.LightGray.copy(alpha = 0.6f)
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Daftar Tugas
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(daftarTugas) { tugas ->
                TugasItemCard() // Panggil card item di sini
            }
        }
    }
}

@Composable
fun TugasItemCard() {
    // Card untuk setiap item tugas
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
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Ikon di kiri (ganti-ganti)
            Icon(Icons.Default.Timer,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(32.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Kolom Teks (Judul, Deskripsi, Chips)
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Tugas 3 RDF", style = MaterialTheme.typography.titleMedium)
                Text(text = "Body text for whatever you’d like to say. Add main takeaway points, quotes, anecdotes, or even a very very short story. ",
                    style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    SuggestionChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Prioritas Tinggi",
                            color = Color(0xFFFFFF).copy(alpha = 1f),
                        ) },
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = Color(0xC00F0C).copy(alpha = 0.9f)
                        ),
                        border = BorderStroke(
                            color = Color(0xC00F0C).copy(alpha = 1f),
                            width = 1.dp
                        )
                    )
                    SuggestionChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Sedang Dikerjakan",
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
                }
            }
        }
    }
}