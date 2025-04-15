package br.senai.sp.jandira.lion_school_projeto.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lion_school_projeto.R

val ModifierImage = Modifier
    .size(150.dp)
    .padding(end = 20.dp)

@Composable
fun TelaInicial(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lionschool),
                        contentDescription = stringResource(R.string.img_description),
                        modifier = ModifierImage
                    )
                    Text(
                        text = stringResource(R.string.text_home),
                        fontSize = 43.sp,
                        color = Color(0xFF3347B0),
                        fontWeight = FontWeight.Bold,
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.favorite_course),
                        fontSize = 23.sp,
                        color = Color(0xFF3347B0),
                        fontWeight = FontWeight.Bold,
                    )
                    Card(
                        modifier = Modifier
                            .width(65.dp)
                            .padding(top = 12.dp)
                            .height(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFC23D)
                        )
                    ){}
                    Text(
                        text = stringResource(R.string.text_description),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color(0xFF9E9FA4),
                        modifier = Modifier
                            .padding(top = 32.dp)
                    )
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFC23D)
                        ),
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(2.dp, Color(0xFF3347B0)),
                        modifier = Modifier
                            .padding(top = 150.dp)
                            .width(300.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.get_started),
                            color = Color(0xFF3347B0)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 120.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.youtube),
                        contentDescription = stringResource(R.string.youtube_description),
                        modifier = Modifier.size(40.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.twitter),
                        contentDescription = stringResource(R.string.twitter_description),
                        modifier = Modifier.size(40.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = stringResource(R.string.instagram_description),
                        modifier = Modifier.size(40.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.communication),
                        contentDescription = stringResource(R.string.facebook_logo),
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaInicial()
}