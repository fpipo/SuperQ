package CENTRALSQ

class SqtDetalleCodigoCambio {
    Date fechaAplico
    int enviado

    SqtEstatus estatus
    SqtTienda tienda

    static belongsTo = [cambio:SqtCodigoCambio]

    static constraints = {
        enviado nulluable: true
        fechaAplico nullable: true
    }
}
