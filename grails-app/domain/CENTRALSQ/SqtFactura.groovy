package CENTRALSQ

class SqtFactura {
    String id
    Date diaOperacion
    String nombre
    String apaterno
    String amaterno
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

    SqtTienda tienda
    SqtCliente cliente
    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtUsuario usuarioMod, usuarioAutorizacion

    static hasMany = [detalles:SqtDetalleFactura]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        nombre maxSize: 50
        apaterno maxSize: 50
        amaterno maxSize: 50
        rfc maxSize: 15
        razonSocial maxSize: 250
        calle maxSize: 50
        colonia maxSize: 50
        municipio maxSize: 50
        cp maxSize: 5
        ciudad maxSize: 50
        comentarios maxSize: 50
        mensaje maxSize: 250
        tipoPago maxSize: 100
        numTarjeta maxSize: 100
        enviado nullable:true
    }
}
