package com.example.gmail

// EmailItem.kt
data class EmailItem(val senderName: String, val emailSubject: String){
    var selected = false
    var selectedStar= false
}