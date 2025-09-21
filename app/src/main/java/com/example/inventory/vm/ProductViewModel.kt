package com.example.inventory.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.inventory.model.Product
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    // Estado del producto, observable desde la UI
    private val _poduct = MutableLiveData(Product("Mouse", 98.56))
    val product: LiveData<Product> get() = _poduct

    // Estado del color, observable desde el UI
    private val colors = listOf(
        0xFFE57373.toInt(), // Rojo
        0xFF81C784.toInt(), // Verde
        0xFF64B5F6.toInt(), // Azul
        0xFFFFD54F.toInt(), // Amarillo
        0xFF9575CD.toInt()  // Morado
    )

    private val _nameColor = MutableLiveData(colors.first())
    val nameColor: LiveData<Int> get() = _nameColor

    private val productList = listOf(
        Product("Teclado Mécanico", 750.00),
        Product("Monitor 24 pulgadas", 1500.00),
        Product("Webcam HD", 445.25),
        Product("Silla Ergonómica", 2220.00),
        Product("Audifonos", 520.00)
    )

    // Lógica para cambiar el producto y el color
    fun changeProduct() {
        _poduct.value = productList.random()
        _nameColor.value = colors.random()
    }
}