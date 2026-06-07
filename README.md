### Taller n°3 Programación Orientada a Objetos

<p>
<strong>Integrante:</strong> Vicente Renato Galaz Palacios <br>
<strong>RUT:</strong> 21.831.202-0 <br>
<strong>Usuario:</strong> whoskanito
</p>

### Estructura del Proyecto  

 El proyecto cuenta las siguientes Clases:
- **App**: Main del proyecto, se encarga de inicializar el código.
- **Sistema**: Implementación de ISistema. Contiene la lógica principal del programa, gestiona las colecciones de Magos y Hechizos, realiza la carga y persistencia de datos en los archivos .txt, y muestra los métodos que el Menú consume.  
- **ISistema**: Interfaz de Sistema, define el contrato de métodos públicos que Sistema debe implementar.  
- **Menu**: Gestiona la interacción con el usuario a través de Scanner. Muestra los paneles Administrador y Analista, recoge los datos ingresados y los comunica a Sistema. 
No contiene lógica de negocio.  
- **Mago**: Representa a un mago del sistema. Contiene su nombre y una colección dinámica de hechizos que domina.  
- **Hechizo**: Clase abstracta, base de las clases hijas, define los atributos comunes.  
- **HechizoAgua, HechizoFuego, HechizoPlanta, HechizoTierra**: Clases hijas de Hechizo, representa los hechizos que lo magos pueden aprender. Cada una contiene los atributos específicos de su elemento.  

  
### Instrucciones de ejecución
  
1.  Clonar o descargar el repositorio desde github.
2. Abrir proyecto en eclipse.
3. Ejecutar la clase "APP.java" como aplicación Java.
