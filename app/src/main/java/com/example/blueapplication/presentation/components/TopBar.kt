package com.example.blueapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blueapplication.R
import com.example.blueapplication.ui.theme.Purple40
import com.example.blueapplication.ui.theme.PurpleGrey40
import com.example.blueapplication.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    backgroundColor: Color = Color.Transparent,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    TopAppBar(
        title = {
        },
        backgroundColor = if (isSystemInDarkTheme()) PurpleGrey80 else Purple40,
        contentColor = Color.White,
        elevation = 0.dp,
        actions = {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                IconButton(
                    onClick = { /* TODO: Open help */ },

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.support),
                        contentDescription = "help",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { /* TODO: Open notification */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = "notification",
                        tint = Color.White
                    )
                }
                Text(
                    text = "خانه",
                    modifier = Modifier
                        .padding(start = 80.dp, end = 80.dp)
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                IconButton(
                    onClick = { /* TODO: Open download */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.download),
                        contentDescription = "download",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { /* TODO: Open search */ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "search",
                        tint = Color.White
                    )
                }
            }
        },
        modifier = modifier.background(color = Color.Transparent)
    )
}

@Preview
@Composable
fun ShowAppBarPreview(){
    TopBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    )
}