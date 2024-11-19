package com.example.recipies

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun recipiescreen(
    modifier: Modifier = Modifier,
    viewstate: MainViewmodel.Recipiestate,
    navigatetodeatil: (category) -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewstate.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewstate.error != null -> {
                Text(
                    text = "error loading categories ${viewstate.error}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                //display the list of categories
                categoryscreen(categories = viewstate.list, navigatetodeatil)
            }
        }
    }
}

@Composable
fun categoryscreen(categories: List<category>, navigatetodeatil: (category) -> Unit) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            CategoryItem(category = category, navigatetodeatil)
        }
    }
}

@Composable
fun CategoryItem(
    category: category,
    navigatetodeatil: (category) -> Unit,
) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
        .clickable {
            navigatetodeatil(category)
        }, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}












