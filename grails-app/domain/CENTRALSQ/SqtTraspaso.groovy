package CENTRALSQ

class SqtTraspaso {
    String id
    String tipotraspaso
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

    SqtTienda tiendaOrigen
    SqtTienda tiendaDestino
    SqtMovimiento movimiento
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static hasMany = [traspaso:SqtDetalleTraspaso]

    static constraints = {

        comentarios maxSize: 250
        enviado nullable:true
    }
}
