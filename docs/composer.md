# ¿Qué es la clase Composer?
Composer se encarga de gestionar la presentación en formato de texto de los elementos en pantalla y proporciona herramientas útiles para el desarrollador

* Completar

# Funcionalidades
1. Calcula y se actualiza en base al tamaño de la terminal asignada
2. Composer tiene un tamaño mínimo asignado (obligatorio) asignado a través del constructor
    1. Si el tamaño es menor que el mínimo, se lanza NotEnoughSizeException
3. Permite utilizar ComposerElement, formas más complejas de añadir información
4. Permite guardar el estado del compositor
5. El ComposerElement contiene un Collider opcional
   1. Cuando ComposerElement contiene Collider, Composer comprueba que no se escribe encima de ningún otro ComposerElement con Collider. Si se detecta la colisión, no se dibuja el nuevo Elemento
        1. Esto es útil para no sobreescribir parcialmente elementos
   2.