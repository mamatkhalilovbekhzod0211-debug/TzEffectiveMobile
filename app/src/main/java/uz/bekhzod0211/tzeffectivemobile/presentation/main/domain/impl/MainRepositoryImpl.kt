package uz.bekhzod0211.tzeffectivemobile.presentation.main.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.CoursesApi
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response.CoursesResponse
import uz.bekhzod0211.tzeffectivemobile.presentation.main.domain.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val coursesApi: CoursesApi
) : MainRepository {
    override suspend fun getCourses(): Flow<Result<CoursesResponse>> = flow {
        val result = coursesApi.getCourses()
        if (result.isSuccessful) {
            val body = result.body()
            if (body != null) {
                emit(Result.success(body))
            }
        } else {

        }
    }


}