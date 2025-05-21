package com.bueno.alvaro.laboratoriocalificado02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bueno.alvaro.laboratoriocalificado02.databinding.ActivityEjercicio02DetailBinding

class Ejercicio02Detail : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02DetailBinding

    private val NOMBRE_CLIENTE_KEY = "NOMBRE_CLIENTE_KEY"
    private val NUMERO_CLIENTE_KEY = "NUMERO_CLIENTE_KEY"
    private val PRODUCTOS_KEY = "PRODUCTOS_KEY"
    private val CIUDAD_KEY = "CIUDAD_KEY"
    private val DIRECCION_KEY = "DIRECCION_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityEjercicio02DetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showInformation(intent.extras)
    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            val nombre_cliente = bundle.getString(NOMBRE_CLIENTE_KEY)
            val numero_cliente = bundle.getString(NUMERO_CLIENTE_KEY)
            val productos = bundle.getString(PRODUCTOS_KEY)
            val ciudad = bundle.getString(CIUDAD_KEY)
            val direccion = bundle.getString(DIRECCION_KEY)

            binding.tvNombreCliente.text = "$nombre_cliente"
            binding.tvNumCliente.text = "$numero_cliente"
            binding.tvProductos.text = "$productos"
            binding.tvUbicacion.text = "$ciudad - $direccion"
        }
    }
}