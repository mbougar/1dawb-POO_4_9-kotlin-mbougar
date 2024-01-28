import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Clase que representa una tarea.
 * @property identificador Identificador de la tarea.
 * @property descripcion Descripción de la tarea.
 * @property estado Estado actual de la tarea.
 */
class Tarea(val identificador: Int, val descripcion: String, estado: EstadoTarea) {

    private var fechaRealizacion: LocalDateTime? = null

    /**
     * Estado de la tarea.
     */
    var estado = estado
        set(value) {
            if (value == EstadoTarea.ACABADA) {
                fechaRealizacion = LocalDateTime.now()
            }
            field = value
        }

    /**
     * Devuelve una representación de cadena de la tarea.
     */
    override fun toString(): String {
        return "Identificador: $identificador\n - Descripción: $descripcion\n - Estado: $estado\n - Fecha de realización: ${fechaRealizacion?.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))}"
    }
}