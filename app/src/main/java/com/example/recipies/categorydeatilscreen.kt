package com.example.recipies

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun categorydetailscreen(category: category) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category.strCategory,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 30.dp),
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory}thumbnail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategoryDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 22.sp,
            fontFamily = FontFamily.Cursive
        )

    }
}