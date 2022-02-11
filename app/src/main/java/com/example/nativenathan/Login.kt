package com.example.nativenathan

import android.widget.Toast

class Login (var username:String, var password:String) {
    override fun toString(): String {
        return "$username $password"
    }
}