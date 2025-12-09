package uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network

import retrofit2.Response
import retrofit2.http.GET
import uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response.CoursesResponse

interface CoursesApi {
    @GET("/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun getCourses(): Response<CoursesResponse>
}