package CENTRALSQ

class SqtDetalleCodigoCambio {
    Date fechaAplico
    int enviado

    SqtEstatus estatus

    static belongsTo = [cambio:SqtCodigoCambio]

    static constraints = {
        enviado nulluable: true
    }
}
