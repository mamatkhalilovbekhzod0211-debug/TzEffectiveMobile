package uz.bekhzod0211.tzeffectivemobile.presentation.main.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response.Course
import uz.bekhzod0211.tzeffectivemobile.presentation.main.domain.MainRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _courses = MutableLiveData<List<Course>>()
    val courses: LiveData<List<Course>>
        get() = _courses


    fun load() {
        viewModelScope.launch {
            repository.getCourses()

                .onStart {

                }
                .onEach {
                    it.onFailure {

                    }
                    it.onSuccess { response ->
                        _courses.value = response.courses
                    }

                }
                .catch {
                }.launchIn(viewModelScope)
        }
    }
}