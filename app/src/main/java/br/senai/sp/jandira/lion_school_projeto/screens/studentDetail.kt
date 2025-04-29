package br.senai.sp.jandira.lion_school_projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school_projeto.R

@Composable
fun StudentDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F8)), // Light gray background
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profileimg), // Replace with actual student image
                contentDescription = "Foto da Luana",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color(0xFFF9A825), CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Luana Oliveira Dias",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3347B0) // Dark blue
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "001 - Técnico em Desenvolvimento de Sistemas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Performance Section
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Desempenho",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF3347B0), // Dark blue
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                PerformanceBar(subject = "SIOP", score = 77, color = Color(0xFF8BC34A)) // Green
                PerformanceBar(subject = "INRI", score = 86, color = Color(0xFF4CAF50)) // Green
                PerformanceBar(subject = "INNU", score = 59, color = Color(0xFFFFEB3B)) // Yellow
                PerformanceBar(subject = "HA", score = 100, color = Color(0xFF8BC34A)) // Green
                PerformanceBar(subject = "SERE", score = 44, color = Color(0xFFF44336)) // Red
                PerformanceBar(subject = "CAES", score = 52, color = Color(0xFFFFC107)) // Amber
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Push the Concluído to the bottom

        // Concluído Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE0F2F7)) // Light cyan
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.profileimg), // Replace with your check circle icon
                contentDescription = "Concluído",
                tint = Color(0xFF4CAF50), // Green
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Concluído",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4CAF50) // Green
            )
        }
    }
}

@Composable
fun PerformanceBar(subject: String, score: Int, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = subject,
            modifier = Modifier.width(40.dp),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .background(Color(0xFFE0E0E0)) // Light gray bar background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(score / 100f)
                    .background(color)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = score.toString(),
            modifier = Modifier.width(30.dp),
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StudentDetailScreenPreview() {
    StudentDetailScreen()
}