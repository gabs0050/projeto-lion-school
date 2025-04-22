// ScreenCourses.kt
package br.senai.sp.jandira.lion_school_projeto.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school_projeto.R
import br.senai.sp.jandira.lion_school_projeto.model.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCourses() {
    val colorStart = Color(0xFF3347B0)
    val colorEnd = Color(0xFFCFD4EA)
    val titleColor = Color(0xFFFFC23D)

    val courses = listOf(
        Course(
            "DS",
            R.string.ds_name,
            R.string.ds_description_long,
            R.string.ds_duration,
            R.drawable.programing
        ),
        Course(
            "RDS",
            R.string.rds_name,
            R.string.rds_description_long,
            R.string.rds_duration,
            R.drawable.internet
        ),
        Course(
            "ELE",
            R.string.ele_name,
            R.string.ele_description_long,
            R.string.ele_duration,
            R.drawable.chip
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.lionschool),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = stringResource(R.string.text_home),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 18.sp
                )
            }
        }
        Divider(color = Color(0xFFFFC23D), thickness = 2.dp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon_description)
                    )
                },
                placeholder = { Text(stringResource(R.string.find_your_course)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFFFC23D),
                    unfocusedBorderColor = Color(0xFFFFC23D),
                    cursorColor = Color(0xFFFFC23D),
                    containerColor = Color(0xFFECE9E9)
                )
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.list),
                contentDescription = stringResource(R.string.courses_icon_description),
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.courses),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(courses) { course ->
                CourseCard(course = course, colorStart = colorStart, colorEnd = colorEnd, modifier = Modifier.height(180.dp))
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, colorStart: Color, colorEnd: Color, modifier: Modifier = Modifier) {
    val titleColor = Color(0xFFFFC23D)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(colorStart, colorEnd)
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xFFFFC23D)),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = course.imageResId ?: R.drawable.ic_launcher_foreground),
                    contentDescription = stringResource(course.nameResId),
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = course.acronym,
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold,
                    color = titleColor
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(course.nameResId),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 6.dp)
            )
            Text(
                text = stringResource(course.descriptionResId),
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.7f),
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.time),
                    contentDescription = stringResource(R.string.duration_icon_description),
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(course.durationResId),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LionSchoolPreview() {
    ScreenCourses()
}