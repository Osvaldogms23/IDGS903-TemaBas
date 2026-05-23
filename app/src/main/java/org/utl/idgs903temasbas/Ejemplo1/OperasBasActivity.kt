package org.utl.idgs903temasbas.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.utl.idgs903temasbas.R

class OperasBasActivity : AppCompatActivity() {

    lateinit var edtNumero1: EditText
    lateinit var edtNumero2: EditText

    lateinit var btnSumar: Button
    lateinit var btnRestar: Button
    lateinit var btnMultiplicar: Button
    lateinit var btnDividir: Button

    lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas_bas)

        edtNumero1 = findViewById(R.id.edt1)
        edtNumero2 = findViewById(R.id.edt2)

        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        txtResultado = findViewById(R.id.txtResultado)

        btnSumar.setOnClickListener {
            operar("+")
        }

        btnRestar.setOnClickListener {
            operar("-")
        }

        btnMultiplicar.setOnClickListener {
            operar("*")
        }

        btnDividir.setOnClickListener {
            operar("/")
        }
    }

    fun operar(operacion: String) {

        if (edtNumero1.text.toString().isEmpty() ||
            edtNumero2.text.toString().isEmpty()) {

            Toast.makeText(this, "Ingresa ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = edtNumero1.text.toString().toDouble()
        val num2 = edtNumero2.text.toString().toDouble()

        var resultado = 0.0

        when (operacion) {

            "+" -> resultado = num1 + num2

            "-" -> resultado = num1 - num2

            "*" -> resultado = num1 * num2

            "/" -> {

                if (num2 == 0.0) {
                    Toast.makeText(this,
                        "No se puede dividir entre 0",
                        Toast.LENGTH_SHORT).show()
                    return
                }

                resultado = num1 / num2
            }
        }

        txtResultado.text = "Resultado: $resultado"
    }
}