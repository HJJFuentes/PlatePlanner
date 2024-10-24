package com.example.plateplanner

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

// Define the API endpoint and request parameters
interface SpoonacularService {

    @GET("recipes/findByIngredients")
    fun searchRecipesByIngredients(
        @Query("ingredients") ingredients: String,
        @Query("apiKey") apiKey: String,
        @Query("number") number: Int = 10 // Limit number of results
    ): Call<List<Recipe>>
}
