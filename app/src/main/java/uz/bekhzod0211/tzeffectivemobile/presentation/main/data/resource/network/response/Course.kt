package uz.bekhzod0211.tzeffectivemobile.presentation.main.data.resource.network.response


import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("hasLike")
    val hasLike: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: String,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("rate")
    val rate: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("title")
    val title: String
)