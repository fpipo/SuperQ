package CENTRALSQ

class SqtFactura {
    String id
    Date diaOperacion
    String nombre
    String aPaterno
    String aMaterno
    String rfc
    String razonSocial
    String calle
    String colonia
    String municipio
    String cp
    String ciudad
    Double subTotal
    Double iva
    Double total
    int desglose
    String tipoOrigen
    String comentarios
    String mensaje
    Date fechaCancelacion
    Date fechamod
    int enviado
    String tipoPago
    String numTarjeta
    String usoCfdi
    String serie
    String metodoPago
    SqtCliente cliente
    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtUsuario usuarioAutorizacion

    static hasMany = [detalles:SqtDetalleFactura]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {

    }
}
