# ProTrainer

## Diseño:

### ProTrainer (jFrame - Main):

![Captura de pantalla 2025-03-24 141606](https://github.com/user-attachments/assets/9b20ba74-69fe-42bd-8f97-c74ff1fececd)

> jMnuBar

- mnuOpciones: Opciones de Logout(cerrar sesión usuario) y Exit(cerrar aplicación).
- mnuAbout: contiene el About con la información del autor.

> pnlMain

- lblLogo: Logo de al aplicación.
- btnAcceso: Al pulsar se abrirá 'DialogLogin' para ingresar el email y la contraseña e iniciar sesión.
- lblUrl: Icono que nos reenvia a la página web.



### DialogLogin:

![Captura de pantalla 2025-03-24 141601](https://github.com/user-attachments/assets/c72671bc-86bd-49fe-b5b4-f580f6ed72e0)

- txtFieldEmail: Permite escribir el email.
- fldPassword: Permite escribir la contraseña.
- jChkMostrarContraseña: Permite ver la contraseña.
- lblMsg: Muestra mensaje si no se ha escrito bien el email o la contraseña.
- btnLogin: Evento que se accionará al ser pulsado.


### Panel Menú (jPanel):

![Captura de pantalla 2025-03-24 142151](https://github.com/user-attachments/assets/370c6b26-c494-48d5-b3bf-d320dfbb48c7)

> jMnuBar

- mnuOpciones: Opciones de Logout(cerrar sesión usuario) y Exit(cerrar aplicación).
- mnuAbout: contiene el About con la información del autor.
- mnuCalendario: Muestra un calendario con los entrenamientos asignado a una fecha y usuario.
    
> :warning: **Nota**: Para que el componente del calendario funcione, se debe añadir la dependencia al Pom.xml y el .jar.
    
> Dependencia
    
        <dependency>
            <groupId>unknown.binary</groupId>
            <artifactId>ComponentCalendar-1.0-SNAPSHOT</artifactId>
            <version>SNAPSHOT</version>
        </dependency>
        
> Archivo .jar

Descargar el .jar: https://github.com/nereamo/ProTrainer/tags
    
Añadir .jar a proyecto: 
1. Carpeta Dependencies --> Click Derecho (Add Dependency) y rellenar los campos con la información de la dependencia.
2. Buscar en la lista de dependencias el ComponentCalendar --> Click derecho(Manually install artifact) y buscar el componente.

> pnlDarkGrey

- lstUsuarios: Lista de los usuarios asignados al instructor, al pulsar sobre un usuario, mostrará los entrenamientos asociados.
- lblUsuarioIcon: Icono de usuario.

> pnlLightGrey

- lblWorkouts: Label con el título de la tabla.
- tblEntrenamientos: Muestra los entrenamientos que tiene asociados un usuario.
- btnNuevoWorkout: Permite crear un nuevo entrenamiento asignandolo a un usuario.
![Captura de pantalla 2025-03-24 143923](https://github.com/user-attachments/assets/1dd2de99-4ae7-482a-8d06-83b92f4745f0)

      - lblTitulo -> Titulo del formulario.
      - cmbBoxUsuario -> Permite seleccionar un usuario.
      - spnrFecha -> Permite seleccionar una fecha.
      - txtFieldComentario -> Permite añadir un comentario.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnGuardar -> Acciona el evento.
  
- btnEliminarWorkout: Permite eliminar un entrenamiento que no tenga ejercicios asignados.
![Captura de pantalla 2025-03-24 143928](https://github.com/user-attachments/assets/2724ea1d-57fb-4b8a-a314-de34d8c27849)

      - lblTitulo -> Titulo del formulario.
      - cmbBoxUsuario -> Permite seleccionar un usuario.
      - lstWorkouts -> Muestra la lista de entrenamientos asignados al usuario.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnEliminar -> Acciona el evento.


- lblEjercicios: Label con el título de la tabla.
- tblEjercicios: Muestra los ejercicios que tiene asociados un workout.
- btnNuevoEjercicio: Permite crear un nuevo ejercicio.
![Captura de pantalla 2025-03-24 144845](https://github.com/user-attachments/assets/785e6a06-d912-490e-921e-a1971e9a982d)

      - lblTitulo -> Titulo del formulario.
      - txtFieldNombre -> Permite Añadir un nombre al ejercicio.
      - txtFieldDescripcion -> Permite Añadir una descripción al ejercicio.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnGuardar -> Acciona el evento.

- btnEliminarEjercicio: Permite eliminar un ejercicios que no esté asignando a un entrenamiento.
![Captura de pantalla 2025-03-24 144851](https://github.com/user-attachments/assets/058abef5-8009-441e-8fe6-d8868084e6da)

      - lblTitulo -> Titulo del formulario.
      - lstEjercicios -> Lista que permite seleccionar un ejercicio.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnEliminar -> Acciona el evento.
  
- btnEditarEjercicio: Permite cambiar el nombre y la descripción de un ejercicio.
![Captura de pantalla 2025-03-24 144855](https://github.com/user-attachments/assets/23ccaa4c-b980-4ae6-b7c7-f99cb8d52532)

      - lblTitulo -> Titulo del formulario.
      - cmbBoxEjercicios -> Permite seleccionar el ejercicio que se va a modificar.
      - txtFieldNombre -> Permite escribir un nuevo nombre para el ejercicio.
      - txtFieldDescripcion -> Permite escribir una nueva descripción para el ejercicio.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnGuardar -> Acciona el evento.
  
- btnAsignarEjercicios: Permite asignar ejercicios a un entrenamiento.
![Captura de pantalla 2025-03-24 144900](https://github.com/user-attachments/assets/537b94b2-3ece-48d1-b6d3-e40d5116350d)

      - lblTitulo -> Titulo del formulario.
      - cmbBoxUsuarios -> Permite seleccionar un usuario.
      - cmbBoxWorkouts -> Se mostrarán los entrenamientos que tiene asignado el usuario.
      - lstEjercicios -> Lista que muestra y permite seleccionar que ejercicio sera asignado.
      - lblMsg -> Muestra un mensaje de error si alguno de los campos no es correcto.
      - btnGuardar -> Acciona el evento.



## Affordance
- jDialogLogin -> Se ha añadido la opción de poder ver la contraseña.
  
- jTables -> Al pasar el cursor sobre las filas se muestran resaltadas además del cursor en forma de mano.

- jButtons -> Al pasar el cursor sobre el botón se muestra en forma de mano y es resaltado por un borde.

- jList -> Al pasar el cursor sobre las filas se muestran resaltadas además del cursor en forma de mano.


## Feedback:

Se ha añadido feedback visual a los elementos con los que el usuario debe interactuar para un mayor entendimiento y usabilidad.

Ahora al pasar el ratón sobre un botón éste es destacado, en la listas y tablas las filas son resaltadas y al hacer click sobre un elemento es resaltado con otro color, cada uno de los elementos tiene un 'tooltip' que mustra una breve descripción del elemento sobre el que está el cursor.

En cada formulario hay un lblMsg mostrando información d elos pasos a realizar.
Al completar el formulario, si la opción es correcta mostrá un mensaje informando que la acción es correcta, de lo contrario mostrá un mensaje de error.

## Otros:

1. Creación de las clases DAO: Se han creado las vclases DAO para separa la lógica dependiendo del objeto.
2. Creación de la clase 'EventosMouse' para unir la lógica que hace referéncia al aspecto visual y feedback de los botones, listas y tablas.
3. Eliminación de mensajes JOPtionPane inecesários, ahora los mensages de 'selecciona un usuario' o similares, se muestran en en jLabel, evitando así la carga de ventanas abiertas pero informando en todo momento de los pasos a realizar antes de cualquier cambio.

## Cambios respect al anterior proyecto TrainMaster:

        -Elementos como botones, tablas y listas se han resaltado.
        -Cambio en el color de la aplicación.
        -Cambio de botones con texto por botónes mas visuales.
        -Creación de clases para separar la lógica de elementos visuales e interacción con la base de datos.
        -Se ha implementado el MigLayout para poder ampliar la aplicación.


## Imágenes del antes y después:

> Antes:
    
![Captura de pantalla 2025-03-21 144835](https://github.com/user-attachments/assets/563b9f88-0ccc-4bcc-810e-88012ef5d85a)

![Captura de pantalla 2025-03-21 144844](https://github.com/user-attachments/assets/21e9f7ae-a992-4d92-bf6a-a35f227e279e)

![Captura de pantalla 2025-03-21 144858](https://github.com/user-attachments/assets/058cfa11-f7bb-480a-b76b-54c3fda09d14)


> Después:

![Captura de pantalla 2025-03-21 144338](https://github.com/user-attachments/assets/f2a96cfb-3142-41a2-acea-5cc210195c15)

![Captura de pantalla 2025-03-21 144342](https://github.com/user-attachments/assets/4fc552fb-8e91-4af6-ac51-990763f59cd2)

![Captura de pantalla 2025-03-21 144353](https://github.com/user-attachments/assets/5e42c35a-0599-48e5-b71c-a1da34c59eef)




