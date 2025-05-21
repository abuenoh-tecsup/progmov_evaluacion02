package com.bueno.alvaro.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bueno.alvaro.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    private val NOMBRE_CLIENTE_KEY = "NOMBRE_CLIENTE_KEY"
    private val NUMERO_CLIENTE_KEY = "NUMERO_CLIENTE_KEY"
    private val PRODUCTOS_KEY = "PRODUCTOS_KEY"
    private val CIUDAD_KEY = "CIUDAD_KEY"
    private val DIRECCION_KEY = "DIRECCION_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        observeButtons()
    }

    private fun observeButtons() {
        binding.btnRegistrar.setOnClickListener {
            if (validateInputs()) {
                goDetailActivity()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val nombreCliente = binding.etNombreCliente.text.toString().trim()
        val numeroCliente = binding.etNumeroCliente.text.toString().trim()
        val productos = binding.etProductos.text.toString().trim()
        val ciudad = binding.etCiudad.text.toString().trim()
        val direccion = binding.etDireccion.text.toString().trim()

        return if (nombreCliente.isEmpty() || numeroCliente.isEmpty() || productos.isEmpty() || ciudad.isEmpty() || direccion.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    private fun goDetailActivity() {
        val nombreCliente = binding.etNombreCliente.text.toString()
        val numeroCliente = binding.etNumeroCliente.text.toString()
        val productos = binding.etProductos.text.toString()
        val ciudad = binding.etCiudad.text.toString()
        val direccion = binding.etDireccion.text.toString()

        val intent = Intent(this, Ejercicio02Detail::class.java)
        intent.putExtra(NOMBRE_CLIENTE_KEY, nombreCliente)
        intent.putExtra(NUMERO_CLIENTE_KEY, numeroCliente)
        intent.putExtra(PRODUCTOS_KEY, productos)
        intent.putExtra(CIUDAD_KEY, ciudad)
        intent.putExtra(DIRECCION_KEY, direccion)
        startActivity(intent)
    }
}
