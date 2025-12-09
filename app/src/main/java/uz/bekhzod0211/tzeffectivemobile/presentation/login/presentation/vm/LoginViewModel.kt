package uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.vm

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val openMainScreenLiveData: LiveData<Unit>
    val openVkLiveData: LiveData<Unit>
    val openOKLiveData: LiveData<Unit>


    fun btnEnterClicked()
    fun btnVKClicked()
    fun btnOkClicked()
}