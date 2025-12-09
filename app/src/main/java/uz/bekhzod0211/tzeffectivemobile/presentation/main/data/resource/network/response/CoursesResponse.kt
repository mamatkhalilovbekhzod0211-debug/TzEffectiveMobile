package uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response


import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses")
    val courses: List<Course>
)