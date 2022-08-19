package com.ibrajix.ajo.ui.statesviewmodel

data class ValidationState(
    val successful: Boolean,
    val errorMessage: String? = null
)