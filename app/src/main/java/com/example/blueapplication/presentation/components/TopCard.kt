package com.example.blueapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blueapplication.R
import com.example.blueapplication.ui.theme.BlueApplicationTheme


@Composable
fun TopCard(
    modifier: Modifier = Modifier
    ,scrollProvider: () -> Int) {
    val maxOffset = with(LocalDensity.current) { 0.dp.toPx() }
    val minOffset = with(LocalDensity.current) { 0.dp.toPx() }
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .offset {
                val scroll = scrollProvider()
                val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
                IntOffset(x = 0, y = offset.toInt())
            }
//            .paint(painterResource(if (isSystemInDarkTheme())
//                R.drawable.header_dark else R.drawable.header_light)
//           ),
    ) {
        Column(
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.CenterHorizontally)
                .wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "۹۳,۹۸۷,۹۱۲ ریال",
                style = TextStyle(textDirection = TextDirection.ContentOrRtl),
                fontSize =  24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "موجودی",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )

        }
        Row(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            CardItem(
                id = R.drawable.chart,
                title = "مدیریت مالی",
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
            )
            CardItem(
                id = R.drawable.spaces,
                title = "باکس",
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
            )
            CardItem(
                id = R.drawable.add,
                title = "شارژ حساب",
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp),
                alpha = 1f
            )

        }
    }
}

@Preview
@Composable
fun TopCardPreview() {
    BlueApplicationTheme {
        Box(Modifier.fillMaxSize()) {
            val scroll = rememberScrollState(0)
            TopCard {
                scroll.value
            }
        }
    }
}
