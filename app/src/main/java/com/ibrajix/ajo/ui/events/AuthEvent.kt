package com.ibrajix.ajo.ui.events

sealed class AuthEvent {

    data class FirstNameChanged(val firstName: String) : AuthEvent()
    data class LastNameChanged(val lastName: String) : AuthEvent()
    data class NumberChanged(val number: String) : AuthEvent()
    data class PasswordChanged(val password: String) : AuthEvent()
    data class CountryChanged(val country: String) : AuthEvent()

    object Submit: AuthEvent()

}
