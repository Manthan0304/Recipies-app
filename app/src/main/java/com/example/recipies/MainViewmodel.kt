package com.example.recipies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewmodel : ViewModel() {
    private val _categoriesstate = mutableStateOf(Recipiestate())
    val categoriesstate : State<Recipiestate> = _categoriesstate

init {
    fetchcategories()
}

    private fun fetchcategories() {
        viewModelScope.launch{
            try{
                val response = recipeservice.getcategories()
                _categoriesstate.value = _categoriesstate.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }catch (e:Exception){
                _categoriesstate.value = _categoriesstate.value.copy(
                    error = "Error fetching categories ${e.message}",
                    loading = false
                )
            }
        }
    }


    data class Recipiestate(
        val loading: Boolean = true,
        val list: List<category> = emptyList(),
        val error: String? = null
    )
}