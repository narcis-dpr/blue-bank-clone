package com.example.blueapplication.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blueapplication.R
import com.example.blueapplication.data.model.Transaction
import com.example.blueapplication.ui.theme.BlueApplicationTheme
import com.example.blueapplication.ui.theme.DarkHighLight
import com.example.blueapplication.ui.theme.HallowBackground
import com.example.blueapplication.ui.theme.LightBackground
import com.example.blueapplication.ui.theme.LightHighLight
import com.example.blueapplication.ui.theme.MelloDarkeWhite
import com.example.blueapplication.ui.theme.MelloLightBlack
import com.example.blueapplication.utiles.transactionIconId
import com.example.blueapplication.utiles.transactionTitleId

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier.background(color = Color.White),
    item: Transaction
) {

    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .clickable { },
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier
            .weight(0.6f)
            ) {
            Text(
                text = item.amount + " ریال",
                color = if (isSystemInDarkTheme()) Color.White else Color.Black,
                style = TextStyle(textDirection = TextDirection.ContentOrRtl),
                modifier = modifier.background(
                    color = if(item.transactionType == 1 || item.transactionType == 3) {
                        if (isSystemInDarkTheme()) DarkHighLight else LightHighLight
                    } else {
                        Color.Transparent
                    }
                ).wrapContentWidth()
            )
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .wrapContentWidth()
                .padding(2.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = transactionTitleId(item.transactionType),
                modifier = Modifier.wrapContentWidth(),
                style = TextStyle(textDirection = TextDirection.ContentOrRtl),
                fontWeight = FontWeight.Bold,
                color =  if (isSystemInDarkTheme()) Color.White else Color.Black
            )
            Text(
                text = item.date,
                modifier = Modifier.wrapContentWidth(),
                style = TextStyle(textDirection = TextDirection.ContentOrRtl),
                color =  if (isSystemInDarkTheme()) MelloDarkeWhite else MelloLightBlack,
                maxLines = 1
            )
        }
        Box(modifier = Modifier
            .wrapContentSize()
            .weight(0.3f)) {
            Surface(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(8.dp),
                shape = CircleShape,
                color = Color.White.copy(alpha = 0.1f)
            ) {
                Image(
                    painter = painterResource(transactionIconId(item.transactionType)),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(16.dp),
                )
            }
        }
    }
}


@Preview
@Composable
@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun showTransactionItem() {
    BlueApplicationTheme {
        val sample = Transaction(
            2,
            "یکشنبه، ۱۳ شهریور ۱۴۰۱ ۱۸:۵۷",
            "۳۰,۰۰۰,۰۰۰"
        )
        TransactionItem(modifier = Modifier.fillMaxWidth(), sample)
    }
}