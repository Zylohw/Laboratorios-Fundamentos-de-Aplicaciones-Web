# 🌍 Country Explorer — Explorador de Países

Aplicación web que consume la [REST Countries API](https://restcountries.com) para buscar y explorar información turística de cualquier país del mundo.

Desarrollado como proyecto del **Módulo 1: Fundamentos de Aplicaciones Web** — Galileo University.

---

## 🎥 Video

> **Nota:** El video de presentación solo es accesible con una cuenta **@galileo.edu**

[https://youtu.be/cCPPorSqbHk](#)

---

## 🚀 Funcionalidades

- 🔍 **Búsqueda en tiempo real** con debounce para evitar llamadas excesivas a la API
- 🗺️ **Filtro por región** combinado con la búsqueda por nombre
- 🃏 **Cards** con bandera, nombre, población, capital y subregión de cada país
- 🪟 **Modal** con información detallada al hacer clic en una card
- ❤️ **Sistema de favoritos** con persistencia en localStorage
- 📱 **Diseño responsivo** con Tailwind CSS

---

## 🛠️ Tecnologías

| Tecnología | Uso |
|---|---|
| HTML5 semántico | Estructura del documento |
| Tailwind CSS 4 | Estilos con clases utilitarias |
| TypeScript | Lógica de la aplicación con tipado estático |
| Fetch API | Consumo de la REST Countries API |
| localStorage | Persistencia de favoritos |
| Vite | Build tool y servidor de desarrollo |

---

## ⚙️ Instalación y uso

```bash
# Instalar dependencias
npm install

# Iniciar servidor de desarrollo
npm run dev

# Build de producción
npm run build
```

---

## 📚 Conceptos aplicados

- **TypeScript** — interfaces, tipos, genéricos y null safety
- **DOM manipulation** — creación de elementos, event delegation y data attributes
- **Async/Await** — manejo de promesas y estados de carga
- **Event Bubbling** — propagación de eventos y `stopPropagation()`
- **Debouncing** — optimización de llamadas a la API
- **localStorage** — persistencia de datos en el navegador

---

## 🌐 API utilizada

[REST Countries API](https://restcountries.com) — API pública y gratuita con información de todos los países del mundo.
