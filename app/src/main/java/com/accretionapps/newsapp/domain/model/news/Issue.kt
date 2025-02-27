package com.accretionapps.newsapp.domain.model.news


import com.google.gson.annotations.SerializedName

data class Issue(
    @SerializedName("date_issued")
    val dateIssued: String,
    @SerializedName("url")
    val url: String
)