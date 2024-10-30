package com.example.plateplanner

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// API Client
object ApiClient {
    private const val BASE_URL = "https://api.spoonacular.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

// Food API Service
interface FoodApiService {
    @GET("food/products/search")
    suspend fun searchProducts(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String
    ): retrofit2.Response<ProductResponse>
}

// Data classes for response
data class ProductResponse(val products: List<Product>)
data class Product(val id: Int, val title: String, val price: Double) // Adjust fields as needed

class Function2Activity : AppCompatActivity() {
    private lateinit var apiService: FoodApiService
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var recyclerView: RecyclerView
    private val productAdapter = ProductAdapter() // RecyclerView adapter for products

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function2)

        // Initialize Retrofit and API service
        apiService = ApiClient.retrofit.create(FoodApiService::class.java)

        // Initialize views
        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        recyclerView = findViewById(R.id.tVName)

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = productAdapter

        // Set up search button click listener
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                searchProducts(query) // Perform search
            } else {
                Log.e("Function2Activity", "Search query is empty")
            }
        }
    }

    private fun searchProducts(query: String) {
        // API call on a background coroutine
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.searchProducts(query = query, apiKey = "1f0036bf631b4c14a9afe9309d33cba0Y")

                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()

                    // Update UI on main thread
                    withContext(Dispatchers.Main) {
                        productAdapter.submitList(products)
                    }
                } else {
                    Log.e("Function2Activity", "Search failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("Function2Activity", "Exception during search: ${e.message}")
            }
        }
    }
}