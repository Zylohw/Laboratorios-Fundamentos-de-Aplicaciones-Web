# Laboratorio Módulo 5: Firebase & AI
**Curso:** Fundamento de Aplicaciones Web  
**Alumno:** [Tu nombre]  
**Fecha:** Marzo 2026

---

## Descripción

Laboratorio basado en la app **AI Chef** que integra Firebase Authentication, Cloud Firestore, Firebase Storage y Firebase AI Logic con Gemini para generar recetas a partir de imágenes de ingredientes.

---

## Video de Demostración

🎥 [https://youtu.be/-L6oS7XeYoY](#)

> **Nota:** El video solo está disponible para cuentas **@galileo.edu**

---

## Parte 1: Sistema de Favoritos

**Archivos modificados:**
- `domain/model/Recipe.kt` → campo `isFavorite`
- `ui/viewmodel/ChefViewModel.kt` → `toggleFavorite()`, `filteredRecipes`, `showOnlyFavorites`
- `ui/screens/HomeScreen.kt` → ícono de corazón y filtro

**¿Qué se implementó?**
- Ícono de corazón en cada receta para marcar/desmarcar favoritos
- Sincronización en tiempo real con Firestore
- Filtro en la barra superior para ver solo recetas favoritas

---

## Parte 2: Compartir Recetas

**Archivos modificados:**
- `ui/screens/RecipeDetailScreen.kt` → botón compartir y captura de pantalla
- `AndroidManifest.xml` → configuración FileProvider
- `res/xml/file_paths.xml` → rutas FileProvider

**¿Qué se implementó?**
- Botón para compartir en el detalle de la receta
- Captura del composable como imagen usando `GraphicsLayer`
- Share sheet nativo de Android para compartir con cualquier app
- Limpieza de archivos temporales después de compartir


