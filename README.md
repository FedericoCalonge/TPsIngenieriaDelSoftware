# TPsIngenieriaDelSoftwareYPOO
>Trabajos Prácticos para las materias Ingeniería Del Software y Programación Orientada a Objetos (POO), de la Universidad Nacional de Avellaneda.
>
>Profesores: Fernando Asteasuain (Ingeniería Del Software) y Martin Miguel Machuca (Programación Orientada a Objetos).

### Requirements

**Todos estos proyectos estan programados en JAVA. Además, para los proyectos 2-, 5- y 6- se utilizó una Base de Datos (BD) en MYSQL y se utilizó el Plugin Windows Builder para Eclipse para la construcción de ventanas en las aplicaciones.**

**Para el uso y ejecución de todos los proyectos en JAVA mediante Eclipse-IDE se debe:**
*1- Crear un Proyecto "Java Project" en Eclipse mediante "File --> New..."
*2- Copiar la/s carpeta/s (que contienen los archivos .java) o directamente los archivos .java (dentro de la carpeta "JAVA") y pegarla/s/os en la carpeta "src" del Proyecto creado previamente.
*3- En caso que aparezca un error, esto se debe a que el nombre del paquete al cual agregamos los archivos .java es el predefinido o no es el mismo indicado en los archivos .java. Para esto, se debe: Seleccionar los archivos Java pertenecientes al "default package" (dentro de Eclipse), click derecho, refactor, move y por último crear el nombre del paquete correspondiente.
*4- Por último ejecutar con "Run" el "main" correspondiente (VER debajo en la seccion "USO"; donde para cada proyecto, especificamos el "main" correspondiente).

**Para los proyectos 2-, 5- y 6- (con BD en MySQL y Windows Builder) se debe (antes de ejecutar el archivo "main"):**
*1- Crear la BD especificada. Para esto, debemos ejecutar el Script .sql ubicado en la carpeta "BDMySQL" que ya tiene todas las sentencias para la creación de la BD con todas sus tablas (se recomienda la utilización de MySQL Workbench para esto).
*2- Añadir al proyecto el/los JAR/S correspondiente/s; estos se encuentran dentro de la carpeta "JARs". Para añadir un .jar a nuestro Proyecto debemos hacer click derecho en nuestro Proyecto (en Eclipse), ir a propiedades, Java build path, pestaña libraries, add external jars y ahí finalmente añadimos el/los .jar/s correspondiente/s dentro de la carpeta "JARs" (si hay algún JAR marcado con "errores", debemos eliminarlo de ahí).
*3- En la carpeta "JAVA" encontrarán una imagen .png o .jpg, la cual se debe colocar en la carpeta del Proyecto de Eclipse (NO dentro de src, sino dentro de la carpeta padre de src).
*4- Para la instalación de Windows Builder en Eclipse: seguir las instrucciones de https://download.eclipse.org/windowbuilder/latest/
*5- Dentro de la clase "ConexionBD.java" se encuentran 3 variables para definir la conexión entre JAVA y MySQL. Se deben MODIFICAR estas variables de acuerdo a nuestra conexión. Por ejemplo, en mi caso yo utilicé la conexión a mi BD en MySQL desde mi localhost (puerto 3307) mediante el usuario root y la password 0202. De acuerdo a esto, mis variables las definí así: 
```
 	private static String urlBD = "jdbc:mysql://localhost:3307/BDTPFINAL?useSSL=false";
	private static String usuario = "root";
	private static String pass = "0202";
```

## 1-POO-TPAlmacenes
>Autor: Federico Calonge.

### Consigna
Leer el archivo "Enunciado.pdf".

### Uso
El "main" correspondiente que se debe ejecutar es "TestMain.java".


## 2-POO-TPFinal
>Autores: Federico Calonge y Matias Suarez.

### Consigna
Leer el archivo "Enunciado.pdf".

### Uso
El "main" correspondiente que se debe ejecutar es "VentanaSistema.java".
En "DiagramaDeClases.pdf" y "EsquemaBD" especificamos el diagrama de clases y modelo de BD utilizados respectivamente.

## 3-Ing.Soft.-TPCajeroATM
>Autores: Federico Calonge, Sarah Ceballos Pardo, Matias Flores, Ivan Kwist.

### Consigna
Leer el archivo "Enunciado.pdf" y realizar un diagrama de casos de uso, diagrama de clases y para al menos 4 cuatro casos de uso realizar su especificacion en pasos en lenguaje natural, diagramas de secuencia que ejemplifiquen el comportamiento, los diagramas de objetos asociados y su IMPLEMENTACION EN CODIGO. (uno de los casos de uso OBLIGATORIOS es el de retirardinero). 

>Como NO realizamos todas las implementaciones en código/en JAVA (solo algunas), hay clases que no estan implementadas (como logger) y métodos que tampoco lo estan, tal como validarMonto(int monto, String cuenta) y  obtenerCuentas(String nroTarjeta) en #InterfazBanco.

El Informe Final con la Consigna realizada es el archivo "Informe-Final.pdf".

### Uso
El "main" correspondiente que se debe ejecutar es "ATM.java".

## 4-Ing.Soft.-TPSubte
>Autores: Federico Calonge, Sarah Ceballos Pardo, Matias Flores, Ivan Kwist.

### Consigna
Leer el archivo "Enunciado.pdf" y especificar las principales responsabilidades del sistema a desarrollar a través de casos de uso, diagramas de actividad, diagramas de estado u otra notación que se crea necesaria. Luego se debe especificar los requerimientos a través de users stories.

El Informe Final con la Consigna realizada es el archivo "TPSubte.pdf".

### Uso
El "main" correspondiente que se debe ejecutar es "Main.java".

## 5-Ing.Soft.-TPHealth
>Autores: Federico Calonge, Sarah Ceballos Pardo, Matias Flores, Ivan Kwist.

### Consigna
En base al archivo "Health Casos de uso.pdf" se debe realizar su  implementación en código (en JAVA).
En este TP realizamos las implementaciones para los siguientes casos de uso: [FR02] Complaint specification, [FR01] Query information, [FR13] Register new employee, [FR14] Update employee y [FR10] Login.

### Uso
El "main" correspondiente que se debe ejecutar es: "VentanaLogin.java" para luego acceder a "VentanaPrincipal.java". En "QueryTPFinalHealth.sql" insertamos un empleado/usuario con ID=1 y pass=1234 (para realizar el login inicial).

>Nota: En consultar denuncia hay que poner una letra y el numero. Por ej. A1 es denuncia animal (A) con ID=1.

## 6-Ing.Soft.-TPFinal
>Autores: Federico Calonge, Sarah Ceballos Pardo, Matias Flores, Ivan Kwist.

### Consigna
Desarrollar una aplicación aplicando metodologías agiles (SCRUM). La aplicación será una red social denominada “¿Qué estás leyendo?”, la cual llevará información sobre los últimos libros leídos y las últimas series y películas vistas por una persona.

El Informe Final con la Consigna realizada es el archivo "InformeFinal.pdf".

### Uso
El "main" correspondiente que se debe ejecutar es: "VentanaPrincipal.java", para luego acceder a "LogueoUsuario.java" y luego a "VentanaMenu.java". En "TPFinal-SQL.sql" insertamos usuarios (con sus respectivos mails y passwords: por ejemplo profe@gmail.com con su pass profe) que podremos utilizar para el logueo inicial.
