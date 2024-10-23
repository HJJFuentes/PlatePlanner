package com.example.plateplanner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Function2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function2)


    }
}
import mysql.connector

connection = mysql.connector.connect(
    host="localhost"
    user="root",
    password="Doritoscr5678",
    database="ingredients_plateplanner";
)

cursor = connection.cursor()
cursor.execute("SELECT * FROM vegetables;")

for row in cursor.fetchall():
print(row)

connection.close()

