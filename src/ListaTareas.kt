

/**
 * Clase que representa una lista de tareas.
 */
class ListaTareas {

    private val tareas = mutableListOf<Tarea>()
    private var identificador = 50001

    /**
     * Agrega una nueva tarea a la lista.
     * @param descripcion Descripción de la tarea.
     */
    fun agregarTarea(descripcion: String) {

        tareas.add(Tarea(identificador, descripcion, EstadoTarea.PENDIENTE))
        println("Se ha agregado una nueva tarea con identificador $identificador")
        identificador++
    }

    /**
     * Cambia el estado de una tarea.
     * @param id Identificador de la tarea.
     * @param nuevoEstado Nuevo estado de la tarea.
     */
    fun cambiarEstadoTarea(id: Int, nuevoEstado: EstadoTarea) {

        for (i in tareas.indices) {

            if (tareas[i].identificador == id) {

                tareas[i].estado = nuevoEstado
                println("Se ha modificado la tearea con el identificador $id")
            } else {

                println("No hay ninguna tearea con el identificador $id")
            }
        }
    }

    /**
     * Elimina una tarea de la lista.
     * @param id Identificador de la tarea a eliminar.
     */
    fun eliminarTarea(id: Int) {

        for (i in tareas.indices) {

            if (tareas[i].identificador == id) {

                tareas.remove(tareas[i])
                println("Se ha eliminado la tearea con el identificador $id")
            } else {

                println("No hay ninguna tearea con el identificador $id")
            }
        }
    }

    /**
     * Muestra todas las tareas de la lista.
     */
    fun mostrarListaTareas() {

        println("Lista de tareas:"
        )
        for (tarea in tareas) {

            println(tarea)
        }
    }

    /**
     * Muestra las tareas pendientes de la lista.
     */
    fun mostrarTareasPendientes() {

        println("Lista de tareas pendientes:")

        for (tarea in tareas) {

            if (tarea.estado == EstadoTarea.PENDIENTE) {
                println(tarea)
            }
        }
    }

    /**
     * Muestra las tareas realizadas de la lista.
     */
    fun mostrarTareasRealizadas() {

        println("Lista de tareas pendientes:")

        for (tarea in tareas) {

            if (tarea.estado == EstadoTarea.ACABADA) {
                println(tarea)
            }
        }
    }
}