package CENTRALSQ

class SqtDetalleTraspaso {
    Double cantidadSugerida
    Double cantidadSurtida
    Double cantidadRecibida
    Double costoPromedio
    Double ivaCostoPromedio
    int sugerido
    int enviado
    Double ventaSemana

    SqtTienda tienda
    SqtProducto producto
    SqtMotivoDevolucion motivoDevolucion

    static belongsTo = [traspasos: SqtTraspaso]

    static constraints = {
        enviado nulluable: true
    }
}
