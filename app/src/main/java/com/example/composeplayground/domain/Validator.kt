package com.example.composeplayground.domain

object Validator {
    fun isValidPassword(password: String): Boolean {
        val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$%#])[A-Za-z\\d@$%#]{8,62}$".toRegex()
        return regex.matches(password)
    }
    fun validUsername(username: String): Boolean {
        val pattern = "^[a-zA-Z0-9_]{6,20}$".toRegex()
        return pattern.matches(username)
    }

    fun validEmail(email: String): Boolean {
        val pattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$")
        return pattern.matches(email)
    }

}