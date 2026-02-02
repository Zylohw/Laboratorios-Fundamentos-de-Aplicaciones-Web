# 📱 Lab 2 – Jetpack Compose

Este repositorio contiene la entrega del **Laboratorio 2**, compuesto por **dos aplicaciones Android** desarrolladas con **Jetpack Compose**.  
El objetivo principal del laboratorio es practicar **manejo de estado**, **composición** y **efectos secundarios**, sin aplicar aún arquitecturas avanzadas como MVVM.

---

## 🧪 Aplicaciones Incluidas

### 🧙 App 1: RPG Character Sheet

Aplicación basada en un dado tipo RPG que permite generar estadísticas para un personaje estilo D&D.

**Funcionalidades:**
- Generación de **tres estadísticas**:
  - Strong
  - Dexterity
  - Intelligence
- Cada estadística puede generar un valor aleatorio de forma independiente.
- Cálculo automático del **puntaje total**.
- Mensajes de validación:
  - **Total <= 30** → *Re-roll recommended!*
  - **Total ≥ 50** → *Good!*
- Uso de componentes reutilizables y manejo de estado en Compose.


---

### 🚦 App 2: Traffic Light Simulator

Aplicación que simula el comportamiento de un **semáforo automático**, sin interacción del usuario.

**Funcionalidades:**
- Tres luces: **Rojo, Amarillo y Verde**.
- Cambio automático de luces en un ciclo infinito.
- Tiempos realistas:
  - Rojo: 2 segundos
  - Verde: 2 segundos
  - Amarillo: 1 segundo
- Uso de:
  - `enum class` para representar estados
  - `LaunchedEffect`
  - Corrutinas (`delay`)
  - Manejo de estado en Jetpack Compose

# 🎥 Video Explicativo

📌 **Enlace al video:**  
https://youtu.be/0GJf4gWqArA

⚠️ **Nota:**  
El video **solo puede visualizarse iniciando sesión con una cuenta institucional `@galileo.edu`**.
