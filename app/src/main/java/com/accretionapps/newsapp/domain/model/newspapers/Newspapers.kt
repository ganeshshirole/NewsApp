package com.accretionapps.newsapp.domain.model.newspapers


import com.google.gson.annotations.SerializedName

data class Newspapers(
    @SerializedName("newspapers")
    val newspapers: List<Newspaper>
)