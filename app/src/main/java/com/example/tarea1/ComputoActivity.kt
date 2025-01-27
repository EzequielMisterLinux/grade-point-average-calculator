package com.example.tarea1
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea1.R

class ComputoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computo)

        val computoNumber = intent.getIntExtra("COMPUTO", 1)
        val etGrade1 = findViewById<EditText>(R.id.etGrade1)
        val etGrade2 = findViewById<EditText>(R.id.etGrade2)
        val etGrade3 = findViewById<EditText>(R.id.etGrade3)

        findViewById<Button>(R.id.btnCalculate).setOnClickListener {
            val grades = listOf(etGrade1, etGrade2, etGrade3).map {
                it.text.toString().toFloatOrNull() ?: 0f
            }
            val average = grades.average().toFloat()

            getSharedPreferences("Grades", Context.MODE_PRIVATE).edit().apply {
                putFloat("computo$computoNumber", average)
                apply()
            }
            Toast.makeText(this, "Promedio guardado: $average", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}