package com.ibrajix.ajo.ui.validation

import com.ibrajix.ajo.ui.statesviewmodel.ValidationState

class ValidateCountry {

    fun execute(country: String): ValidationState {

        if (country.isEmpty()){
            return ValidationState(
                successful = false,
                errorMessage = "Enter a valid country"
            )
        }

        return ValidationState(
            successful = true
        )

    }

}