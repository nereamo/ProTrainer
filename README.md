# ProTrainer

Diseño de la aplicación:

ProTrainer (jFrame - Main):

Menú superior:

    - Barras de menú: Contiene las opciones de LogOut(cerrar sesión usuario) y Exit(cerrar aplicación).
    - Icono de Información: contiene el About con información del autor.

Centro de la página:

    - Icono del nombre de la WEB.
    - Icono usuario: Al pulsar abre un formulario para ingresar el email y la contraseña y un botón para iniciar sesión.
    - Icono búsqueda: Al pulsarlo, no reenvia a la página web.

![Pagina Inicial](https://github.com/user-attachments/assets/d69040d7-8ee8-4602-aca4-1e3ef41627e1)

Panel Menú (jPanel):

Menú superior encontramos dos opciones:

    - Barras de menú: Contiene las opciones de LogOut(cerrar sesión usuario) y Exit(cerrar aplicación).
    - Icono de Información: Contiene el About con información del autor.
    - Icono de calendario: Muestra un calendario con los entrenamiento asignnados según el dia.
    
NOTA: Para que el componente del calenadrio funcione, se debe añadir la dependencia al Pom.xml y el .jar:
    
Dependencia:
    
        <dependency>
            <groupId>unknown.binary</groupId>
            <artifactId>ComponentCalendar-1.0-SNAPSHOT</artifactId>
            <version>SNAPSHOT</version>
        </dependency>
        
Archivo .jar:

    Descarga .jar: 
        https://github.com/nereamo/ProTrainer/tags
    
    Añadir .jar a proyecto: 
        1º) Carpeta Dependencies --> Click Derecho (Add Dependency) y rellenar los campos con la información de la dependencia.
        2º) Buscar en la lista de dependencias el ComponentCalendar --> Click derecho(Manually install artifact) y buscar el componente.

Centro de la página:

    - Lista de usuarios: Al iniciar sesión en instructor, mostrará los usuarios asignados en la lista.
    
    - Tabla entrenamientos: Al pulsar sobre un usuario de la lista, mostrará sus entrenamientos.
    *La tabla entrenamiento tiene dos botones: añadir un entrenamiento y eliminar un entrenamiento, 
    al pulsar alguna de las opciones se mostrará un formulario.

    - Tabla ejercicios: Al pulsar sobre un entrenamiento de la tabla entrenamientos, mostrará los ejercicios asignados.
    *La tabla ejercicios tiene cuatro botones: añadir un ejercicio, eliminar un ejercicio, editar un ejercicio (permite
    cambiar el nombre y la descripción) y asignar un ejercicio a un entrenamiento. Al pulsar alguna de las opciones se
    mostrará un formulario.
    
![Pagina del Usuario](https://github.com/user-attachments/assets/4b589dab-c9ff-4ab5-8666-16a10db652c7)

Affordance:

    jTables:
            Al pasar el cursor sobre las filas se muestran resaltadas además del cursor en forma de mano.

    jButtons: 
            Al pasar el cursor sobre el botón se muestra en forma de mano y es resaltado por un borde.

    jList: 
            Al pasar el cursor sobre las filas se muestran resaltadas además del cursor en forma de mano.

    jDialogLogin:
            Se ha añadido la opción de poder ver la contraseña.


Feedback:

        Se ha añadido feedback visual a los elementos con los que el usuario debe interactuar para un mayor entendimiento y usabilidad.

Otros:

        -Se han creado las clases DAO para separar la lógica al interactuar con la base de datos.
        -Creación de una clase para unir la lógica de los elementos visuales.
        -Eliminación de JOPtionPane inecesários, ahora los mensages de 'selecciona un usuario' o similares, se muestran en en jLabel, evitando así la carga de ventanas abiertas pero informando en todo momento de los pasos a realizar antes de cualquier cambio.

Cambios respect al anterior proyecto TrainMaster:

        -Elementos como botones, tablas y listas se han resaltado.
        -Cambio en el color de la aplicación.
        -Cambio de botones con texto por botónes mas visuales.
        -Creación de clases para separar la lógica de elementos visuales e interacción con la base de datos.
        -Se ha implementado el MigLayout para poder ampliar la aplicación.


Imagenes del antes y después:

Antes:
    
![Captura de pantalla 2025-03-21 144835](https://github.com/user-attachments/assets/563b9f88-0ccc-4bcc-810e-88012ef5d85a)

![Captura de pantalla 2025-03-21 144844](https://github.com/user-attachments/assets/21e9f7ae-a992-4d92-bf6a-a35f227e279e)

![Captura de pantalla 2025-03-21 144858](https://github.com/user-attachments/assets/058cfa11-f7bb-480a-b76b-54c3fda09d14)


Después:

![Captura de pantalla 2025-03-21 144338](https://github.com/user-attachments/assets/f2a96cfb-3142-41a2-acea-5cc210195c15)

![Captura de pantalla 2025-03-21 144342](https://github.com/user-attachments/assets/4fc552fb-8e91-4af6-ac51-990763f59cd2)

![Captura de pantalla 2025-03-21 144353](https://github.com/user-attachments/assets/5e42c35a-0599-48e5-b71c-a1da34c59eef)




