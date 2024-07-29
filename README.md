# ProyectoFinal_Estructura

JOSUE GONZALEZ
DENNIS ANGAMARCA

LABERINTO - Búsqueda de Caminos: 
Este proyecto implementa una solución para encontrar el camino más corto en un laberinto utilizando varios algoritmos de búsqueda. La aplicación permite a los usuarios definir un laberinto, especificar puntos de inicio y fin, y encontrar el camino más corto utilizando diferentes algoritmos de búsqueda. Los resultados se visualizan en una interfaz gráfica de usuario (GUI) desarrollada en Java.

Descripción del Problema: 
El objetivo es encontrar el camino más corto en un laberinto representado como una matriz bidimensional. Cada celda en la matriz puede ser transitada (indicada por '0') o bloqueada (indicada por '2'). La tarea es desarrollar un sistema que permita a los usuarios definir el laberinto, establecer un punto de inicio y un punto final, y encontrar el camino más corto entre estos dos puntos. Los resultados deben ser presentados en la interfaz gráfica de usuario en lugar de solo en la consola.

Propuesta de Solución

Marco Teórico
Programación Dinámica:
La programación dinámica es una técnica de diseño de algoritmos que resuelve problemas complejos descomponiéndolos en subproblemas más simples y almacenando los resultados de estos subproblemas para evitar cálculos repetidos.

BFS (Breadth-First Search):
BFS es un algoritmo que explora los nodos de un grafo nivel por nivel. Empieza desde el nodo raíz y explora todos los nodos vecinos antes de pasar a los siguientes niveles. Es ideal para encontrar el camino más corto en grafos no ponderados.
DFS (Depth-First Search):
DFS explora los nodos de un grafo en profundidad, avanzando lo más lejos posible a lo largo de una rama antes de retroceder. Utiliza una pila para rastrear los nodos visitados. Aunque no garantiza el camino más corto, es útil para explorar todos los caminos posibles. Su complejidad también es 

Descripción de la Propuesta de Solución:
La solución desarrollada incluye una aplicación en Java con una interfaz gráfica que permite:

Configurar el Laberinto: Los usuarios pueden definir el tamaño del laberinto y configurar las celdas como transitables o bloqueadas.
Definir Puntos de Inicio y Fin: Se especifican los puntos de inicio y fin para el camino.
Seleccionar Algoritmo de Búsqueda: Los usuarios pueden elegir entre diferentes algoritmos de búsqueda (Recursivo, Memoización, BFS, DFS).
Ejecución y Visualización: El algoritmo seleccionado encuentra el camino más corto y el resultado se muestra en la interfaz gráfica, donde el camino encontrado se resalta en el laberinto.

Herramientas y Lenguajes Utilizados:

Lenguaje de Programación: Java 
Entorno de Desarrollo Integrado (IDE): Apache Neatbeans 17
Bibliotecas y Herramientas:
Swing: Para construir la interfaz gráfica de usuario (GUI).
Colecciones de Java: Para implementar estructuras de datos necesarias para los algoritmos de búsqueda.
Algoritmos Implementados:
Recursivo: Implementación de búsqueda en profundidad recursiva.
Memoización o Cache: Variante de búsqueda en profundidad con almacenamiento de resultados.
BFS: Implementación de búsqueda en anchura para encontrar el camino más corto.
DFS Iterativo: Búsqueda en profundidad utilizando una pila.

Criterios por Integrante:
Cada miembro del equipo contribuyó en áreas específicas del proyecto:
Algoritmos: Implementación y prueba de los algoritmos de búsqueda.
Interfaz Gráfica: Desarrollo de la GUI utilizando Swing.
Integración y Pruebas: Integración de la lógica de los algoritmos con la interfaz gráfica y pruebas para asegurar el correcto funcionamiento del sistema.

Capturas Implementacion de la UI:
En la interfaz primeramente creamos el laberinto ingresando sus filas y columnas posteriormente ingresamos los puntos iniciales y punto final es decir desde donde va iniciar el recorrido o camino y hasta donde termina 

![image](https://github.com/user-attachments/assets/a3d6d7f6-c5eb-4ecc-b41c-4e379999e0f2)

Laberinto Creado se muestra una matriz con ceros ya que aun no seleccionamos el metodo

![image](https://github.com/user-attachments/assets/45b4c3c3-3f04-49bd-ac00-e934f5534e73)

Laberinto despues de seleccionar metodo Recursivo

![image](https://github.com/user-attachments/assets/332eaa52-8109-4fcb-8a4c-80d92f88f0fc)


Aqui una aclaracion cada vez que queremos seleccionar un metodo diferente tenemos que nuevamente crear laberinto para restablecer la matriz a ceros y posterior seleccionamos el metodo para el laberinto.


Laberinto metodo Cache
![image](https://github.com/user-attachments/assets/3f8b96b0-fa50-4d09-b0c9-e73cdd29eee1)


Laberinto metodo BFS

![image](https://github.com/user-attachments/assets/02448e6e-3ccf-439f-b655-a15c4d5b7e88)

Laberinto metodo DFS

![image](https://github.com/user-attachments/assets/fdb99490-1aed-4b1e-a40e-581491a7457e)






Conclusiones:
Entre los algoritmos evaluados, BFS es el más adecuado para encontrar el camino más corto en un laberinto no ponderado debido a su capacidad para explorar nodos nivel por nivel, garantizando que el primer camino encontrado al objetivo es el más corto. DFS, aunque útil para explorar rutas profundas, no garantiza el camino más corto y puede ser menos eficiente que BFS. La búsqueda recursiva y la memoización o cache ofrecen variantes útiles de DFS, pero con limitaciones en términos de eficiencia y garantía de resultados.
