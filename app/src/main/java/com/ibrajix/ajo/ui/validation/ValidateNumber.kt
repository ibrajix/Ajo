package com.ibrajix.ajo.ui.validation

import com.ibrajix.ajo.ui.statesviewmodel.ValidationState

class ValidateNumber {

    fun execute(number: String): ValidationState {

        if (number.isEmpty()){
            return ValidationState(
                successful = false,
                errorMessage = "Enter a valid number"
            )
        }

        return ValidationState(
            successful = true
        )

    }

}