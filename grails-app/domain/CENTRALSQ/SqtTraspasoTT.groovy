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
    int numTransaccionT
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
        fechaSurte nullable: true
        fechaCierre nullable: true
        estatus nullable: true
        tipoTraspaso maxSize: 2
        tipoConsumo maxSize: 2 , nullable: true
        impresion nullable: true
        comentarios maxSize: 250, nullable: true
        impresionDestino maxSize: 10, nullable: true
        numTransaccion nullable: true
        numTransaccionT nullable: true
        pctEfectividad nullable: true
        cantidadNoSolicitada nullable: true
        totalSurtido nullable: true
        totalSugerido nullable: true
        enviado nullable: true
    }
}
