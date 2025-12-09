package uz.bekhzod0211.tzeffectivemobile.presentation.main.domain

import kotlinx.coroutines.flow.Flow
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response.CoursesResponse

interface MainRepository {
    suspend fun getCourses(): Flow<Result<CoursesResponse>>
}