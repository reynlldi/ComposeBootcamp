package com.example.testing

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.albert),
                contentDescription = "foto albert einstein",
                modifier = Modifier
                    .border(2.dp, Color.Blue, CircleShape)
                    .size(60.dp)
                    .clip(CircleShape)
                    .clickable {
                        expanded = !expanded
                    }
                    .alpha(0.5f),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "icon check",
                modifier = Modifier.align(Alignment.BottomEnd),
                tint = Color.Blue
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Albert Einstein")
            Text(
                text = "2 Years Ago",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 8.sp
            )
            if (expanded){
                Text(text = "Pernah tinggal di batam")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}