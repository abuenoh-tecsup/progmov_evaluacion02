package com.bueno.alvaro.laboratoriocalificado02

import android.os.Bundle
import android.widget.Toast
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

    private var nombreCliente: String? = null
    private var numeroCliente: String? = null
    private var productos: String? = null
    private var ciudad: String? = null
    private var direccion: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02DetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showInformation(intent.extras)
        setupButtons()
    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            nombreCliente = bundle.getString(NOMBRE_CLIENTE_KEY)
            numeroCliente = bundle.getString(NUMERO_CLIENTE_KEY)
            productos = bundle.getString(PRODUCTOS_KEY)
            ciudad = bundle.getString(CIUDAD_KEY)
            direccion = bundle.getString(DIRECCION_KEY)

            binding.tvNombreCliente.text = nombreCliente ?: ""
            binding.tvNumCliente.text = numeroCliente ?: ""
            binding.tvProductos.text = productos ?: ""
            binding.tvUbicacion.text = "${ciudad ?: ""} - ${direccion ?: ""}"
        }
    }

    private fun setupButtons() {
        binding.btnLlamar.setOnClickListener {
            val message = "Llamando a $nombreCliente, teléfono: $numeroCliente"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.btnWsp.setOnClickListener {
            val message = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        binding.btnMaps.setOnClickListener {
            val message = "Ubicación: $ciudad - $direccion"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
