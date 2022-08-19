package com.ibrajix.ajo.ui.validation

import com.ibrajix.ajo.ui.statesviewmodel.ValidationState

class ValidateFirstName {

    fun execute(firstName: String): ValidationState {

        if (firstName.isEmpty()){
            return ValidationState(
                successful = false,
                errorMessage = "Enter a valid first name"
            )
        }

        return ValidationState(
            successful = true
        )

    }

}