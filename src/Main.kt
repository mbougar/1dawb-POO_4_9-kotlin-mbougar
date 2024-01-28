


fun main() {
    val listaTareas = ListaTareas()

    do {
        val opcion = mostrarMenu()

        when (opcion) {
            1 -> {
                print("Introduzca la descripción de la tarea: ")
                listaTareas.agregarTarea(readln())
            }
            2 -> {
                try {
                    print("Introduzca el identificador de la tarea: ")
                    listaTareas.eliminarTarea(readln().toInt())
                } catch (e: NumberFormatException) {
                    println("Error, no has introducido un entero. Abortando la eliminación de tarea...")
                }
            }
            3 -> {
                try {
                    print("Introduzca el identificador de la tarea: ")
                    val identificador = readln().toInt()

                    print("Ingrese el nuevo estado (pendiente o acabada): ")
                    val estado = readln()

                    when (estado.lowercase()) {
                        "pendiente" -> listaTareas.cambiarEstadoTarea(identificador, EstadoTarea.PENDIENTE)
                        "acabada" -> listaTareas.cambiarEstadoTarea(identificador, EstadoTarea.ACABADA)
                        else -> println("El estado que ha introducido no coincide con los estados posibles. Abortando el cambio de estado...")
                    }
                } catch (e: NumberFormatException) {
                    println("El valor que has introducido no es un entero. Abortando el cambio de estado...")
                } catch (e: Exception) {
                    println("Ha surgido un error durante la ejecución del programa. Abortando el cambio de estado...")
                }

            }
            4 -> listaTareas.mostrarListaTareas()
            5 -> listaTareas.mostrarTareasPendientes()
            6 -> listaTareas.mostrarTareasRealizadas()
            0 -> println("Cerrando el programa... Hasta pronto!")
        }
        pulseParaContinuar()
    } while (opcion != 0)
}

/**
 * Solicita al usuario que ingrese una opción y la devuelve como un entero.
 * @return La opción ingresada por el usuario.
 */
fun pedirOpcion(): Int {

    var opcion= 0

    print("\nIngrese su opción: ")
    do {
        try {
            opcion = readln().toInt()
        } catch (e: NumberFormatException) {
            print("El valor introducido no coincide con ninguna de las opciones, intentelo otra vez: ")
        }
    }while (opcion !in 0..6)

    return opcion
}

/**
 * Muestra un menú de opciones y solicita al usuario que ingrese una opción.
 * @return La opción seleccionada por el usuario.
 */
fun mostrarMenu(): Int {
    println("\n1. Agregar tarea")
    println("2. Eliminar tarea")
    println("3. Cambiar estado de tarea")
    println("4. Mostrar lista de tareas")
    println("5. Mostrar tareas pendientes")
    println("6. Mostrar tareas realizadas")
    println("0. Salir")

    return pedirOpcion()
}

/**
 * Muestra un mensaje para que el usuario pulse enter para continuar.
 */
fun pulseParaContinuar() {
    println("\nPulse enter para continuar...")
    readln()
    println()
}