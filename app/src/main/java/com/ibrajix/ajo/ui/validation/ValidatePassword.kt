package com.ibrajix.ajo.ui.validation

import com.ibrajix.ajo.ui.statesviewmodel.ValidationState

class ValidatePassword {

    fun execute(password: String): ValidationState {

        if (password.isEmpty()){
            return ValidationState(
                successful = false,
                errorMessage = "Enter a valid password"
            )
        }

        if (password.length < 5){
            return ValidationState(
                successful = false,
                errorMessage = "Password should be more than 6 characters"
            )
        }

        return ValidationState(
            successful = true
        )

    }

}