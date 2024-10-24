package com.example.plateplanner

import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Function1Activity : AppCompatActivity() {

    private val repository = RecipeRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function1)

        // Test ingredients and API key
        val testIngredients = "tomato, cheese"
        val apiKey = "ea087b3041814c9d874cb0a459ed7cf1"

        // Call the repository method
        repository.getRecipesByIngredients(testIngredients, apiKey) { recipes ->
            if (recipes != null) {
                // Log the first recipe title
                Log.d("TEST_RESULT", "First Recipe: ${recipes[0].title}")
            } else {
                Log.e("TEST_RESULT", "Failed to get recipes")
            }
        }
    }


}