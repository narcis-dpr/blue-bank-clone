package com.example.blueapplication

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CardItem(
    id: Int,
    title: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.Transparent)
    ) {
        Surface(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
                .align(Alignment.CenterHorizontally),
            shape = CircleShape,
            color = Color.White.copy(alpha = 0.1f)
        ) {
            Image(
                painter = painterResource(id = id), contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                alignment = Alignment.Center,
            )
        }
        Text(
            text = title,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun showCard() {
    CardItem(
        id = R.drawable.chart,
        title = "مدیریت مالی",
        modifier = Modifier
            .width(80.dp)
            .height(100.dp)
    )
}