package com.example.plateplanner

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class apiservice {

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    object ApiClient {
        private const val BASE_URL = "https://api.spoonacular.com/"

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // FoodApiService.kt
    interface FoodApiService {
        @GET("food/products/search")
        suspend fun searchProducts(
            @Query("query") query: String,
            @Query("number") number: Int = 1,       // Adjust the number of results as needed
            @Query("apiKey") apiKey: String
        ): Response<ProductSearchResponse>
    }

    // Data Models for Responses (ProductSearchResponse, Product)
    data class ProductSearchResponse(
        val products: List<Product>
    )

    data class Product(
        val id: Int,
        val title: String,
        val price: Double?, // Ensure nullable in case the price is not available

    )

}