package com.example.recipies

sealed class screen(val route:String){
    object Recipiescreen:screen("recipiescreen")
    object Detailscreen:screen("categorydetailscreen")
}