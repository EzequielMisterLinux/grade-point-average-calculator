package com.example.tarea1
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea1.R

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val name = intent.getStringExtra("NAME") ?: ""
        val minGrade = intent.getFloatExtra("MIN_GRADE", 0f)
        val tvResults = findViewById<TextView>(R.id.tvResults)
        val prefs = getSharedPreferences("Grades", Context.MODE_PRIVATE)

        findViewById<TextView>(R.id.tvStudentName).text = "Estudiante: $name"

        findViewById<Button>(R.id.btnCalculateFinal).setOnClickListener {
            val c1 = prefs.getFloat("computo1", -1f)
            val c2 = prefs.getFloat("computo2", -1f)
            val c3 = prefs.getFloat("computo3", -1f)

            if (c1 == -1f || c2 == -1f || c3 == -1f) {
                Toast.makeText(this, "Faltan notas por ingresar", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val finalAverage = (c1 + c2 + c3) / 3
            val status = if (finalAverage >= minGrade) {
                tvResults.setTextColor(Color.GREEN)
                "¡Aprobado!"
            } else {
                tvResults.setTextColor(Color.RED)
                "No Aprobado. Faltan ${minGrade - finalAverage} puntos"
            }
            tvResults.text = status
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish()
        }
    }
}