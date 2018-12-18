package CENTRALSQ

class SqtDetalleTraspaso {
    Double cantidadSugerida
    Double cantidadSurtida
    Double cantidadRecibida
    Double costoPromedio
    Double ivaCostoPromedio
    int sugerido
    int enviado
    int redQline
    Double ventaSemana

    SqtTienda tienda
    SqtProducto producto
    SqtMotivoDevolucion motivoDevolucion

    static belongsTo = [traspasos: SqtTraspaso]

    static constraints = {
        enviado nulluable: true
        motivoDevolucion nullable: true
        cantidadSugerida nullable: true
        cantidadSurtida nullable: true
        cantidadRecibida nullable: true
        costoPromedio nullable: true
        ivaCostoPromedio nullable: true
        sugerido nullable: true
        redQline nullable: true
        ventaSemana nullable: true
    }
}
