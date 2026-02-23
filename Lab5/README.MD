# CitySpots - Android App

## Descripción
**CitySpots** es una aplicación Android que permite a los usuarios registrar y visualizar spots (lugares de interés) en un mapa de Google Maps.  
Los usuarios pueden:
- Ver su ubicación actual en el mapa.
- Agregar nuevos spots con foto y ubicación.
- Ver información detallada de cada spot.
- Eliminar spots mediante un botón en la UI con confirmación.

---

## Características principales

### 1. Mapa con marcadores
- Implementado con **Google Maps Compose**.
- Marcadores dinámicos basados en la lista de spots del **ViewModel**.
- Click en marker → muestra **SpotInfoCard** flotante con detalles.
- Click en mapa → oculta la card.

### 2. SpotInfoCard
- Card flotante que reemplaza el InfoWindow nativo.
- Muestra:
  - Imagen del spot (con **SubcomposeAsyncImage** y estado de carga)
  - Título
  - Coordenadas
- Incluye botón **Eliminar**:
  - Llama a `onDelete(spot)`  
  - Muestra un `AlertDialog` para confirmar la eliminación.
  - Al confirmar, elimina el spot del **ViewModel** y oculta la card.

### 3. Agregar nuevos spots
- Se usa un **FloatingActionButton** para navegar a la cámara y crear nuevos spots.

### 4. Seguridad de la API Key
- La **API key de Google Maps** está únicamente en `local.properties`.
- Nunca se sube al repositorio.
- Recomendada restricción de clave:
  - Por app (package + SHA1)
  - Solo para Google Maps SDK for Android


---

# Video 
- https://www.youtube.com/watch?v=5vUJauKp7oE
>Nota: porfavor ver el video con una cuenta .galileo.edu