package CENTRALSQ

class SqtDetalleTraspasoTT {


    String distino
    Double cantidadSugerida
    Double cantidadSurtida
    Double cantidadRecibida
    Double ivaCostoPromedio
    int sugerido
    int enviado
    Double ventasemana


    SqtTraspaso traspaso
    SqtTienda tienda
    SqtProducto producto
    SqtMotivoDevolucion motivoDevolucion

    static constraints = {
        enviado nullable:true

    }
}
