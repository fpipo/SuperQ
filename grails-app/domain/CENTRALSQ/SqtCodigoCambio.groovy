package CENTRALSQ

class SqtCodigoCambio {
    String codigoAnterior
    String codigoNuevo
    Date fechaMod
    int enviado

    SqtProducto producto
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static hasMany = [cambios:SqtDetalleCodigoCambio]

    static constraints = {
        codigoAnterior maxSize: 30
        codigoNuevo maxSize: 30
        enviado nullable:true
    }
}
