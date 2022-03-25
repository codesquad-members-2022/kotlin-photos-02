package com.example.kotlinphotos.ui.common

import android.view.View
import android.widget.CheckBox
import androidx.databinding.BindingAdapter
import com.example.kotlinphotos.model.Type
import com.example.kotlinphotos.model.Type.*


@BindingAdapter("check")
fun checked(view: CheckBox, type: Type) {
    when (type) {
        EDIT -> view.visibility = View.VISIBLE
        READ -> view.visibility = View.INVISIBLE
    }
}