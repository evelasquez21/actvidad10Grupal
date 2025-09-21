```markdown
# Guía de Errores Comunes

### **1. Error: `java.lang.NullPointerException` al acceder a `product.name`**
* **Problema**: La aplicación crashea al iniciar porque el valor de `product.observeAsState()` es `null` inicialmente, antes de que `LiveData` emita su primer valor.
* **Causa**: `observeAsState()` puede devolver `null` si el `LiveData` aún no tiene un valor. Al intentar acceder a `product.name`, se produce un `NullPointerException`.
* **Solución**: Proveer un valor inicial no nulo en `observeAsState`. Esto garantiza que la variable `product` siempre tenga un objeto con el que trabajar, incluso antes de que el ViewModel cargue el estado real.
    ```kotlin
    // Mal: puede ser nulo
    // val product by vm.product.observeAsState()

    // Bien: provee un estado inicial seguro
    val product by vm.product.observeAsState(initial = Product("Cargando...", 0.0))
    ```

### **2. Error: La UI no se actualiza al presionar el botón**
* **Problema**: Al hacer clic en el botón "Cambiar Producto", la función `changeProduct()` se ejecuta, pero nada cambia en la pantalla.
* **Causa**: El error más común es modificar una lista o variable normal dentro del ViewModel en lugar de actualizar el `.value` del `MutableLiveData`. `LiveData` solo notifica a los observadores cuando su valor (`.value`) es reasignado.
* **Solución**: Asegurarse de que la lógica en `changeProduct()` asigne un nuevo objeto a la propiedad `.value` del `MutableLiveData`.
    ```kotlin
    // Mal: no notifica a los observadores
    // private val _product = MutableLiveData(Product("Inicial", 1F))
    // fun change() { _product.value?.name = "Nuevo" } // ¡No hacer esto!

    // Bien: reasigna el valor, activando la actualización
    fun changeProduct() {
        _product.value = productList.random() // Asigna un nuevo objeto Product
    }
    ```

### **3. Error de compilación: `Unresolved reference: observeAsState`**
* **Problema**: Android Studio no reconoce la función `observeAsState` y marca un error en el código.
* **Causa**: Falta la dependencia necesaria que contiene esta función de extensión para integrar `LiveData` con el estado de Compose.
* **Solución**: Añadir la librería `lifecycle-runtime-compose` al archivo `app/build.gradle.kts` y sincronizar el proyecto.
    ```groovy
    dependencies {
        // ... otras dependencias
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0") // [cite: 83]
    }
    ```