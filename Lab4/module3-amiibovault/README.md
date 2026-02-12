# 🎮 Amiibo App

Aplicación Android desarrollada con **Jetpack Compose** que consume la API pública de Amiibo y muestra una lista paginada con funcionalidad de búsqueda y detalle.

---

## 📱 Características

- ✅ Arquitectura **MVVM**
- ✅ Patrón **Repository (Offline-First)**
- ✅ Base de datos local con **Room**
- ✅ Consumo de API con **Retrofit**
- ✅ Paginación local
- ✅ Búsqueda reactiva en tiempo real
- ✅ Manejo de errores tipados
- ✅ Estado de UI con `StateFlow`

---

## 🏗️ Arquitectura

La aplicación sigue el patrón **MVVM**:

```UI (Compose)
↓
ViewModel (StateFlow)
↓
Repository
↓
Room Database ←→ API (Retrofit)
```
---

### Flujo de datos

1. La UI observa el `uiState`.
2. El ViewModel obtiene datos del Repository.
3. El Repository:
   - Descarga datos desde la API.
   - Guarda los datos en Room.
4. La UI siempre lee desde la base de datos local.

Este enfoque permite que la app funcione incluso sin conexión.

---

## 🔍 Búsqueda

La búsqueda funciona de manera reactiva usando `combine`:

- Se observa la lista de Amiibos desde Room.
- Se combina con el `searchQuery`.
- Se filtran los resultados en tiempo real.



---

# Video 📽️
- https://youtu.be/ctVc_EWzdu4
> NOTA: ver el video con una cuenta .galileo.edu