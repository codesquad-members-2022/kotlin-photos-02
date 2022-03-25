package com.example.kotlinphotos.ui.doodle

interface Clickable {
    fun onLongClick()

    fun onClick(position: Int)
}