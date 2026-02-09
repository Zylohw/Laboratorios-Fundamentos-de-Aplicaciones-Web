# 🎵 Stream App – Home Screen (Lab)

Este Aplicación corresponde al laboratorio no.3.La pantalla **Home** de una aplicación de streaming musical, desarrollado con **Jetpack Compose** y siguiendo el patrón **MVVM** con **Unidirectional Data Flow (UDF)**.


---

## 🧱 Arquitectura

La aplicación sigue el patrón **MVVM (Model – View – ViewModel)**:

- **Model**
  - Contiene los datos y la lógica de negocio.
  - Se utiliza un `MusicRepository` con datos mock.

- **View**
  - Implementada con Jetpack Compose.
  - Observa el estado expuesto por el ViewModel.
  - Renderiza la UI en función del estado actual.

- **ViewModel**
  - Gestiona el estado de la pantalla.
  - Expone un `StateFlow<HomeUiState>` observable por la UI.
  - No contiene lógica de UI.

---

## 🔄 Flujo de Datos (UDF)

La aplicación utiliza **Unidirectional Data Flow**:


- El estado fluye **solo** desde el ViewModel hacia la UI.
- Las interacciones del usuario se envían como eventos al ViewModel.
- La UI nunca modifica el estado directamente.

---

## 🖥️ Home Screen

### Estados de la UI

La pantalla Home maneja los siguientes estados mediante un `sealed interface` interfaz que restringe qué otras clases o interfaces pueden implementarla:

- `Loading`: mientras se cargan los datos.
- `Success`: cuando las categorías y canciones se cargan correctamente.
- `Error`: cuando ocurre un error al cargar los datos.

El renderizado de la UI depende completamente del estado actual.

---

## 📦 Componentes Principales

- **HomeScreen**
  - Observa el `uiState` del `HomeViewModel`.
  - Renderiza la UI según el estado (`Loading`, `Success`, `Error`).

- **HomeContent**
  - Muestra la lista de categorías usando `LazyColumn`.

- **CategorySection**
  - Representa una sección por categoría.
  - Contiene una lista horizontal de canciones.

- **SongCard**
  - Muestra la información de una canción.
  - Soporta interacción de clic y clic en favorito.

---

## ⭐ Favoritos

- El usuario puede interactuar con el botón de favorito (corazón).


---

## 🛠️ Tecnologías Utilizadas

- Kotlin
- Jetpack Compose
- StateFlow
- MVVM
- Koin (Inyección de dependencias)
- Material 3

---

