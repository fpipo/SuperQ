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
    SqtUsuario usuarioMod

    static hasMany = [detalles:SqtDetalleFactura]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        nombre maxSize: 50, nullable:true
        apaterno maxSize: 50, nullable:true
        amaterno maxSize: 50, nullable:true
        rfc maxSize: 15
        razonSocial maxSize: 250, nullable:true
        calle maxSize: 50, nullable:true
        colonia maxSize: 50, nullable:true
        municipio maxSize: 50, nullable:true
        cp maxSize: 5, nullable:true
        ciudad maxSize: 50, nullable:true
        estado nullable:true
        pais nullable:true
        comentarios maxSize: 50, nullable:true
        mensaje maxSize: 250, nullable:true
        tipoPago maxSize: 100, nullable:true
        numTarjeta maxSize: 100, nullable:true
        enviado nullable:true
        usoCfdi maxSize: 10, nullable:true
        serie maxSize: 10, nullable:true
        metodoPago maxSize: 5, nullable:true
    }
}
