package CENTRALSQ

class SqtDetalleTraspasoTT {

    Double cantidadSugerida
    Double cantidadSurtida
    Double cantidadRecibida
    Double ivaCostoPromedio
    int sugerido
    int enviado
    Double ventasemana

    SqtTraspaso traspaso
    SqtTienda origen, destino
    SqtProducto producto
    SqtMotivoDevolucion motivoDevolucion

    static belongsTo = [traspasos: SqtTraspasoTT]

    static constraints = {
        enviado nullable:true
    }
}
