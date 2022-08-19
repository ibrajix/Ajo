package com.ibrajix.ajo.ui.validation

import com.ibrajix.ajo.ui.statesviewmodel.ValidationState

class ValidateLastName {

    fun execute(lastName: String): ValidationState {

        if (lastName.isEmpty()){
            return ValidationState(
                successful = false,
                errorMessage = "Enter a valid last name"
            )
        }

        return ValidationState(
            successful = true
        )

    }

}