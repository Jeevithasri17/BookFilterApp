package com.example.bookfilterapp

import retrofit2.http.GET

interface BookServiceAPI {
    @GET("/books")
    suspend fun getBooks():List<Books>
}