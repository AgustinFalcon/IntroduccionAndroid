package com.ifts4.introduccionandroid.fragments

import androidx.core.util.PatternsCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel: ViewModel() {

    //private var _viewState = MutableLiveData<ThirdEnums>()
    //val viewState: MutableLiveData<ThirdEnums> get() = _viewState
    private var email: String = ""
    private var password: String = ""

    var viewState = MutableLiveData<SecondStates>()


    fun validateEmail(email: String) {
        this.email = email
        if (email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            viewState.value = SecondStates.SuccessEmail

        } else {
            viewState.value = SecondStates.ErrorEmail
        }

        validateButtons()
    }

    fun validatePassword(password: String) {
        this.password = password
        if (password.isNotBlank() && password.length > 3) {
            viewState.value = SecondStates.SuccessPassword

        } else {
            viewState.value = SecondStates.ErrorPassword(password = password)
        }

        validateButtons()
    }

    private fun validateButtons() {
        if ((email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) &&
            password.isNotBlank() && password.length > 3) {

            viewState.value = SecondStates.SuccessButton

        } else {
            viewState.value = SecondStates.ErrorButton
        }
    }

    enum class SecondEnums {
        SUCCESS_EMAIL, ERROR_EMAIL, SUCCESS_PASSWORD, ERROR_PASSWORD
    }

    sealed class SecondStates() {
        object SuccessEmail: SecondStates()
        object ErrorEmail: SecondStates()
        object SuccessPassword: SecondStates()
        data class ErrorPassword(val password: String): SecondStates()
        object SuccessButton: SecondStates()
        object ErrorButton: SecondStates()
    }
}