# Minesweeper Competitivo (Java)

¡Bienvenido a **Minesweeper Competitivo**! Esta es una aplicación de escritorio desarrollada en Java usando Swing, diseñada para ofrecer una experiencia del clásico Buscaminas pero con un giro competitivo: incluye gestión de usuarios, ranking por puntuaciones y un registro del historial de partidas.

## Características Principales

* **Sistema de Usuarios y Roles:**
  * Modo **Administrador:** Panel especial para crear usuarios, eliminarlos, y ver todas las estadísticas de la aplicación.
  * Modo **Usuario (Jugador):** Interfaz para jugar, donde todas las victorias y minas encontradas quedan registradas a su nombre.
* **Autenticación Segura:** Las contraseñas se almacenan cifradas en la base de datos utilizando `BCrypt`.
* **Persistencia de Datos (Base de Datos):** La aplicación usa **SQLite** para guardar toda la información (usuarios, contraseñas, estadísticas y ranking). Para evitar que los datos se pierdan al recompilar, la base de datos se guarda de forma segura en `~/.minesweeper/minesweeper.db` (en tu carpeta de usuario del sistema operativo).
* **Diseño Moderno:** Interfaz estilizada en componente Swing, con temas oscuros, resaltados, y pestañas estilo píldora.
* **Ranking Local:** Registro de "Minas Encontradas" y "Partidas Ganadas" para comparar quién es el mejor jugador.

---

## Requisitos del Sistema

Para ejecutar y compilar este proyecto, necesitas tener instalados:

* **Java Development Kit (JDK):** Versión 17 o superior.
* **Maven:** Para gestionar las dependencias (como `sqlite-jdbc` y `jbcrypt`) y compilar el proyecto.

---

## Estructura del Proyecto

El código fuente está organizado en los siguientes paquetes principales (`src/main/java/com/minesweeper`):

* `model/`: Clases de datos (`User`, `Game`).
* `dao/`: Clases para el acceso y manipulación de la base de datos (`UserDAO`, `GameDAO`).
* `db/`: Conexión directa a la base de datos SQLite y scripts de inicialización (`DatabaseConnection`).
* `ui/`: Todos los paneles y elementos gráficos (Swing) como `MainFrame`, `LoginPanel`, `AdminPanel`, `Theme`, etc.
* `logic/`: (Opcional) Clases que gestionan la lógica pura del buscaminas, si se separa de la UI.
* `Main.java`: El punto de entrada principal que inicializa la DB y arranca la interfaz gráfica.

---

## Cómo Iniciar la Aplicación

Existen dos maneras principales de ejecutar este proyecto: usando **Maven** desde la terminal, o utilizando tu **IDE favorito** (IntelliJ IDEA, Eclipse, VS Code).

### Método 1: Ejecutar desde un IDE (Recomendado para desarrollo)

1. Abre tu IDE (por ejemplo, VS Code o IntelliJ).
2. Abre la carpeta del proyecto (`java-minesweeper`).
3. El IDE debería detectar automáticamente el archivo `pom.xml` y descargar las dependencias.
4. Localiza el archivo `src/main/java/com/minesweeper/Main.java`.
5. Haz clic derecho y selecciona **"Run"** (o usa el botón de Play en tu editor).

### Método 2: Ejecutar y Compilar desde la Terminal (Maven)

Asegúrate de estar en el directorio raíz del proyecto (donde se encuentra el archivo `pom.xml`).

**1. Compilar y empaquetar el proyecto:**
Este comando limpia las "builds" anteriores, descarga las dependencias y crea un `.jar` ejecutable:
```bash
mvn clean package
```

**2. Ejecutar la aplicación:**
Una vez compilado, puedes usar el plugin de ejecución de Maven o arrancar directamente el archivo `.jar` generado:

```bash
mvn exec:java -Dexec.mainClass="com.minesweeper.Main"
```
*O si prefieres ejecutar el archivo compilado directamente:*
```bash
java -jar target/minesweeper-competitivo-1.0-SNAPSHOT-jar-with-dependencies.jar
```

& "C:\Program Files\Java\jdk-21\bin\java.exe" -jar target\minesweeper-competitivo-1.0-SNAPSHOT-jar-with-dependencies.jar 
---

## Primer Uso (Credenciales por Defecto)

Al iniciar la aplicación por **primera vez**, la base de datos se genera automáticamente. 

Se creará por defecto un administrador para que puedas gestionar usuarios. Las credenciales son:
* **Usuario:** `admin`
* **Contraseña:** `admin`

Te recomendamos ingresar con este usuario, crear una o más cuentas con rol `USER` (para jugar), e iniciar sesión con esas cuentas nuevas para probar el juego y registrar estadísticas.
