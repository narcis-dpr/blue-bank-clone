package com.example.blueapplication.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.blueapplication.R
import com.example.blueapplication.ui.theme.BlueApplicationTheme

@Composable
fun CircularImage(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background,
    clip: Shape = CircleShape,
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    imageId: Int
) {
    Box(
        modifier = modifier
            .shadow(elevation = elevation, shape = clip, clip = true)
            .then(if (border != null) Modifier.border(border = border, shape = clip) else Modifier)
            .background(
                color = color,
                shape = clip
            )
            .clip(shape = clip)
    ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun ShowImagePreview() {
    Surface(
        modifier = Modifier
            .width(270.dp)
            .height(270.dp),
        shape = CircleShape,
        color = Color.White.copy(alpha = 0.1f)
    ) {
        CircularImage(
            modifier = Modifier.size(80.dp),
            elevation = 2.dp,
            imageId = R.drawable.atm,
        )
    }
}