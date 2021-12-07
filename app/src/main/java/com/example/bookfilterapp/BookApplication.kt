package com.example.bookfilterapp

import android.app.Application
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class BookApplication:Application() {

    public lateinit var books: BookServiceAPI

    override fun onCreate() {
        super.onCreate()
        books = initBooksService()
    }

    private fun initBooksService(): BookServiceAPI {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://httpapibooks.mocklab.io/books/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
            .build()
        return retrofit.create(BookServiceAPI::class.java)
    }

}