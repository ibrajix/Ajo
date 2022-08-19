package com.ibrajix.ajo.ui.statesviewmodel

data class EditTextFormState(

    val country: String = "",
    val number: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",

    val countryErrorMessage: String? = null,
    val numberErrorMessage: String? = null,
    val firstNameErrorMessage: String? = null,
    val lastNameErrorMessage: String? = null,
    val passwordErrorMessage: String? = null

)