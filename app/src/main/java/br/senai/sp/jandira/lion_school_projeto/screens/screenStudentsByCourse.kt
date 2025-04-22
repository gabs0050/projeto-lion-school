package br.senai.sp.jandira.lion_school_projeto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school_projeto.R

data class Student(
    val name: String,
    val registrationNumber: String,
    val year: Int,
    val photoId: Int // Placeholder for image resource ID
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenStudentsByCourse() {
    val students = listOf(
        Student("Luana Oliveira Dias", "20151001018", 2022, R.drawable.profileimg),
        Student("Pedro da Silva Borges", "20151001018", 2022, R.drawable.profileimg),
        Student("Ana Clara Gomes", "20151001018", 2025, R.drawable.profileimg),
        Student("Fabiana Luz Moraes", "20151001018", 2022, R.drawable.profileimg),
        Student("Carlos Augusto Nobre", "20151001018", 2025, R.drawable.profileimg),
        Student("Pedro Xavier", "20151001018", 2025, R.drawable.profileimg),
        Student("Pedro Xavier", "20151001018", 2025, R.drawable.profileimg),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.lionschool),
                contentDescription = stringResource(id = R.string.img_description),
                modifier = Modifier.size(48.dp)
            )
            Text(
                text = "DS",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .background(
                        color = Color(0xFFF9A825),
                        shape = RoundedCornerShape(48.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = stringResource(id = R.string.search_icon_description)) },
            placeholder = { Text(stringResource(id = R.string.find_a_student)) },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF007AFF),
                unfocusedBorderColor = Color.Gray,
                cursorColor = Color(0xFF007AFF)
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3347B0))
            ) {
                Text(text = stringResource(id = R.string.all), color = Color.White)
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF9A825))
            ) {
                Text(text = stringResource(id = R.string.studying), color = Color.White)
            }
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF9A825))
            ) {
                Text(text = stringResource(id = R.string.finished), color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.students_list),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(students) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF9FA9E1)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = student.photoId),
                            contentDescription = stringResource(id = R.string.student_profile_image),
                            modifier = Modifier.size(48.dp).clip(RoundedCornerShape(24.dp))
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = student.name, fontWeight = FontWeight.Bold)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_id_card),
                                    contentDescription = stringResource(id = R.string.enrollment_icon),
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(text = student.registrationNumber, fontSize = 12.sp)
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Card(
                            shape = RoundedCornerShape(4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF9FA9E1))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = student.year.toString(),
                                    fontSize = 12.sp,
                                    color = Color(0xFFF9A825),
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.calendar),
                                    contentDescription = "Ícone de calendário",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenStudentsByCoursePreview() {
    ScreenStudentsByCourse()
}