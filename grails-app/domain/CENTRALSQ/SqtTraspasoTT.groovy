package CENTRALSQ

class SqtTraspasoTT {
    String tipoTraspaso
    Date fechaProceso
    Date fechaSurte
    Date fechaCierre
    String comentarios
    String tipoConsumo
    int impresion
    String impresionDestino
    int numTransaccion
    int numTransacciont
    Double pctEfectividad
    Double cantidadNoSolicitada
    Date fechaMod
    int enviado
    Double totalSugerido
    Double totalSurtido

    SqtTienda origen, destino
    SqtMovimiento movimiento
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static hasMany = [traspaso:SqtDetalleTraspaso]

    static constraints = {
        tipoTraspaso maxSize: 2
        tipoConsumo maxSize: 2
        comentarios maxSize: 250, nullable: true
        impresionDestino maxSize: 10, nullable: true
        enviado nulluable: true
    }
}
