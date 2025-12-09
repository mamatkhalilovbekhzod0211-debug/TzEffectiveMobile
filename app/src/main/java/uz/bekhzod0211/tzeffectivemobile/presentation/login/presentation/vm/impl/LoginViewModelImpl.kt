package uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.vm.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(

): LoginViewModel, ViewModel(){
    private var _openMainScreenLiveData = MutableLiveData<Unit>()
    private var _openVkLiveData = MutableLiveData<Unit>()
    private var _openOKLiveData = MutableLiveData<Unit>()
    override val openMainScreenLiveData: LiveData<Unit>
        get() = _openMainScreenLiveData
    override val openVkLiveData: LiveData<Unit>
        get() = _openVkLiveData
    override val openOKLiveData: LiveData<Unit>
        get() = _openOKLiveData

    override fun btnEnterClicked() {
        _openMainScreenLiveData.value = Unit
    }

    override fun btnVKClicked() {
        _openVkLiveData.value = Unit
    }

    override fun btnOkClicked() {
        _openOKLiveData.value = Unit
    }
}