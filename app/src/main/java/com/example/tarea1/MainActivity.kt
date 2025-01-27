package com.example.tarea1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea1.R

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etMinGrade: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etMinGrade = findViewById(R.id.etMinGrade)

        listOf<Button>(
            findViewById(R.id.btnComputo1),
            findViewById(R.id.btnComputo2),
            findViewById(R.id.btnComputo3)
        ).forEachIndexed { index, button ->
            button.setOnClickListener {
                val intent = Intent(this, ComputoActivity::class.java).apply {
                    putExtra("COMPUTO", index + 1)
                }
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btnResults).setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java).apply {
                putExtra("NAME", etName.text.toString())
                putExtra("MIN_GRADE", etMinGrade.text.toString().toFloatOrNull() ?: 0f)
            }
            startActivity(intent)
        }
    }
}