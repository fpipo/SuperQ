package CENTRALSQ

class SqtCuotaServicio {
    int enviado

    SqtProducto productoRef
    SqtEstatus estatus

    static constraints = {
        enviado nulleable: true
    }
}
