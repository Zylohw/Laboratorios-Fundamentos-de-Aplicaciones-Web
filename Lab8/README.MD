# Challenge Lab — Parte 1: Property Comparison

## Descripción

Se implementó una funcionalidad de comparación de propiedades para la aplicación Real Estate React. Esta feature permite a los usuarios seleccionar hasta 3 propiedades y compararlas lado a lado en una tabla, visualizando métricas clave como precio, habitaciones, baños, área y precio por m². Los mejores valores de cada categoría se resaltan automáticamente.

## Archivos modificados

### Nuevos
- `src/components/CompareButton.tsx` — botón para agregar o quitar una propiedad de la lista de comparación
- `src/pages/ComparePage.tsx` — página con la tabla comparativa lado a lado

### Modificados
- `src/App.tsx` — se agregó el estado compartido (`compareList`) y las funciones `addToCompare`, `removeFromCompare` e `isInCompare`, se registró la ruta `/compare` y se agregó el link en el header
- `src/pages/HomePage.tsx` — se reciben y pasan los props de comparación hacia `PropertyCard`
- `src/components/PropertyCard.tsx` — se actualizó la interface de props y se integró el `CompareButton` en el footer de cada tarjeta

## Video explicativo

> **Nota:** el siguiente recurso solo es accesible con cuentas `@galileo.edu`

🎥 [Link del video](https://youtu.be/7bEfDvxQSE4)

## Navegador a usar
- es un navegador basado en Chromium  Brave