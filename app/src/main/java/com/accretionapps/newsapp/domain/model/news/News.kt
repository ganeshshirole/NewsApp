package com.accretionapps.newsapp.domain.model.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("end_year")
    val endYear: String,
    @SerializedName("issues")
    val issues: List<Issue>,
    @SerializedName("lccn")
    val lccn: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("place")
    val place: List<String>,
    @SerializedName("place_of_publication")
    val placeOfPublication: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("start_year")
    val startYear: String,
    @SerializedName("subject")
    val subject: List<String>,
    @SerializedName("url")
    val url: String
)