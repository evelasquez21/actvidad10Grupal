## Pasos realizados
# 1)Primer acercamiento a android

![imagen](docs/image/Primer%20acercamiento.jpeg)

# apartado de preguntas
1.  ¿Qué carpetas crea Android Studio y para qué sirven?
    Respuesta: 

    manifests: Contiene el archivo AndroidManifest.xml. Este archivo es fundamental, ya que describe las características esenciales de tu aplicación para el sistema operativo Android, como el nombre del paquete, los componentes de la aplicación y los permisos que necesita.

    java: A pesar de su nombre, aquí es donde reside tu código fuente principal, ya sea en Kotlin o Java. Está organizada por paquetes (por ejemplo, com.example.myapp) y contiene tus actividades, ViewModels, y toda la lógica de la aplicación.

    res: Es la carpeta para todos los recursos no compilados de tu aplicación. Se subdivide en:

    drawable: Para imágenes, iconos y otros gráficos.

    layout: Para los archivos XML que definen la interfaz de usuario.

    mipmap: Específicamente para los iconos de la aplicación en diferentes densidades de pantalla.

    values: Para recursos definidos en XML, como cadenas de texto = strings.xml, colores = colors.xml y estilos = themes.xml.

    gradle: Contiene los scripts del sistema de compilación Gradle, que se encarga de construir, probar y empaquetar tu aplicación.

2. ¿Qué es Compose?
    Respuesta: 

    Jetpack Compose es el kit de herramientas moderno y declarativo de Google para construir interfaces de usuario nativas en Android. En lugar de diseñar pantallas arrastrando y soltando componentes en un editor visual o escribiendo archivos XML, con Compose describes tu UI directamente en código Kotlin.
    
3. ¿Qué es el archivo build.gradle (Module) y cómo habilita Compose?
    Respuesta: 
    El archivo build.gradle a nivel de módulo (app/build.gradle.kts o app/build.gradle) es el corazón de la configuración de tu aplicación. Aquí defines:

    El SDK mínimo y objetivo de Android.

    El ID de la aplicación y el número de versión.

    Las dependencias o librerías externas que tu app necesita.

    Para habilitar Compose, este archivo debe contener dos configuraciones clave dentro del bloque android{}:

    buildFeatures: Se activa la opción de Compose.

    composeOptions: Se especifica la versión del compilador de Kotlin que usará Compose.

    Además, se deben agregar las dependencias de Compose en la sección dependencies{} para poder usar sus componentes.

4. ¿Qué es la arquitectura MVVM?
    Respuesta: 

    MVVM son las siglas de Model-View-ViewModel, un patrón de diseño de arquitectura de software que separa la lógica de la aplicación de la interfaz de usuario. Su objetivo es hacer el código más organizado, fácil de probar y mantener.

5. ¿Qué es ViewModel?
    Respuesta: 

    Un ViewModel es una clase diseñada para almacenar y gestionar datos relacionados con la interfaz de usuario de manera consciente del ciclo de vida. Esto significa que los datos que contiene no se destruyen cuando la actividad o el fragmento se recrean, por ejemplo, al girar el dispositivo.

    Su función principal es preparar y proporcionar datos para la UI y reaccionar a las interacciones del usuario. Al hacerlo, desacopla la lógica de los datos de la Vista, lo que hace que el código sea más limpio y robusto.

6. ¿Que es LiveData?
    Respuesta: 

    LiveData es un contenedor de datos observable y consciente del ciclo de vida.
    
    Lo cual significa lo siguiete:

    Contenedor de datos: Básicamente, envuelve un dato (un número, una cadena de texto, una lista de objetos, etc.).

    Observable: Puedes "observar" un LiveData desde la Vista. Cuando el dato que contiene cambia, LiveData notifica automáticamente a sus observadores.

    Consciente del ciclo de vida: Solo notifica a los observadores (como las Vistas) que están en un estado de ciclo de vida activo (por ejemplo, visibles en pantalla). Esto evita errores y fugas de memoria, ya que no intentará actualizar una UI que ya no existe.

7. ¿Qué librerías se necesitan para trabajar con ViewModel y LiveData dentro de Compose?
    Respuesta: 

    ViewModel para Compose: Para poder instanciar y usar ViewModel dentro de tus funciones Composable.

    Observador de LiveData para Compose: Una librería de utilidad que te permite convertir un LiveData en un State<T> que Compose puede observar y reaccionar a sus cambios.