package com.example.plateplanner

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeRepository {

    private val spoonacularApi: SpoonacularService = RetrofitInstance.retrofit.create(SpoonacularService::class.java)

    fun getRecipesByIngredients(ingredients: String, apiKey: String, onResult: (List<Recipe>?) -> Unit) {
        val call = spoonacularApi.searchRecipesByIngredients(ingredients, apiKey)
        call.enqueue(object : Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                if (response.isSuccessful) {
                    Log.d("API_SUCCESS", "Recipes: ${response.body()}")
                    onResult(response.body())
                } else {
                    Log.e("API_ERROR", "Error: ${response.errorBody()?.string()}")
                    onResult(null)
                }
            }

            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                Log.e("API_FAILURE", "Failure: ${t.message}")
                onResult(null) // Handle failure
            }
        })
    }
}
