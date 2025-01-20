# CHICKEN:
## Videojuego tipo idle

- ### Funcionalidad principal 
  - Pulsa espacio para +1 pollo.
  - Los pollos de vez en cuando ponen huevos.
  - Los huevos los puedes vender
  - Con el dinero puedes comprar un gallo
  - Cuando tienes gallos los pollos pueden reproducirse
  - Puedes comprar mejoras para que los pollos pongan más huevos
 
- ### Funcionalidades secundarias
  - Puedes escoger cualquier pollo al azar y ver estadísticas
  - Puedes ver estadísticas generales y compartirlas
  - La partida se guarda
  - Se calcula el tiempo desde la última vez y calcula cuantos huevos se han puesto
  - Puedes personalizar la granja y comprar elementos que aumenten la producción

- ### Requisitos
  - Juego basado en texto con JLine
  - Guardar y cargar partidas con JSON

- ### Estados
  - Pantalla demasiado pequeña
  - Pantalla de inicio
  - Juego principal
  - Pantalla de opciones
  - Pantalla de escoger pollo
  - Pantalla de estadísticas
  - Pantalla AFK
  - Pantalla personalización

- ### Interfaz
  1. Sacar tamaño
  2. Colocar elementos -> Necesario conocer estado
     1. Si no entran pasar a estado de error por tamaño
  3. Dibujar
  4. Esperar
  - A mayores bloquea el cursor y cambia el buffer