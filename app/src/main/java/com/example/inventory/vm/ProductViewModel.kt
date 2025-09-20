import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.inventory.model.Product
import kotlin.random.Random

class ProductViewModel : ViewModel() {
    // TODO(Equipo): Inicializar el estado con un producto por defecto (por ejemplo, Audífonos, 21.99F).
    private val _product = MutableLiveData(/** ??? **/)
    val product: LiveData<Product> get() = _product
    // Colores para el nombre: usen Int ARGB (0xFFAABBCC.toInt()).
    private val colors = listOf(
        // TODO: Agregar al menos cuatro colores
    )

    private val _nameColor = MutableLiveData(colors.first())
    val nameColor: LiveData<Int> get() = _nameColor

    // TODO(Equipo): Implementar la lógica para cambiar el producto y color.
    fun changeProduct() {
        // TODO(Equipo): Crear una lista de productos.
        // TODO(Equipo): Asignar al atributo _product un producto aleatorio.
        // TODO(Equipo): Asignar al atributo _color un color aleatorio
    }
}