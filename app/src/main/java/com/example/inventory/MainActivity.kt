package com.example.inventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.inventory.model.Product
import com.example.inventory.ui.theme.InventoryTheme
import com.example.inventory.vm.ProductViewModel
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    // Conexión del ViewModel
    private val vm: ProductViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventoryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(vm = vm)
                }
            }
        }
    }
}

@Composable
fun MainScreen(vm: ProductViewModel) {
    // Observar el producto desde LiveData.
    val product by vm.product.observeAsState(initial = Product("Cargando...", 0.00))
    // Observar el color del nombre
    val nameColor by vm.nameColor.observeAsState(initial = 0xFF000000.toInt())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = product.nombre,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(nameColor) // Aplicar color dinámico
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Precio: Q${product.precio}",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { vm.changeProduct() }) {
            Text("Cambiar Producto")
        }
    }
}