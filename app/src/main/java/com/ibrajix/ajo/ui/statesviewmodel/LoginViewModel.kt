package com.ibrajix.ajo.ui.statesviewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrajix.ajo.ui.events.AuthEvent
import com.ibrajix.ajo.ui.validation.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateCountry: ValidateCountry,
    private val validateNumber: ValidateNumber,
    private val validatePassword: ValidatePassword,
    ) : ViewModel(){

    var state by mutableStateOf(EditTextFormState())

    private val _shouldNavigate = MutableSharedFlow<Boolean>()
    val shouldNavigate = _shouldNavigate.asSharedFlow()

    fun onEvent(event: AuthEvent){

        when(event){

            is AuthEvent.FirstNameChanged -> {
                state = state.copy(firstName = event.firstName)
            }

            is AuthEvent.LastNameChanged -> {
                state = state.copy(lastName = event.lastName)
            }

            is AuthEvent.NumberChanged -> {
                state = state.copy(number = event.number)
            }

            is AuthEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is AuthEvent.CountryChanged -> {
                state = state.copy(country = event.country)
            }

            is AuthEvent.Submit -> {
                submitData()
            }

        }

    }


    private fun submitData(){

        val country = validateCountry.execute(state.country)
        val number = validateNumber.execute(state.number)
        val password = validatePassword.execute(state.password)

        state = state.copy(
            countryErrorMessage = country.errorMessage,
            numberErrorMessage = number.errorMessage,
            passwordErrorMessage = password.errorMessage,
        )

        val hasError = listOf(
            number,
            password,
            country
        ).any{ !it.successful }


        if (hasError){
            viewModelScope.launch {
                _shouldNavigate.emit(false)
            }
        }
        else{
            viewModelScope.launch {
                _shouldNavigate.emit(true)
            }
        }

    }

}