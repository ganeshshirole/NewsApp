package com.accretionapps.newsapp.domain.model.newspapers


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Newspaper(
    @SerializedName("lccn")
    val lccn: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)