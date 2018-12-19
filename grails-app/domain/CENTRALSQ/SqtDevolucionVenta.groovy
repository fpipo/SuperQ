package CENTRALSQ

class SqtDevolucionVenta {
    String id
    Date diaOperacion
    Double ivaNeto
    Double totalNeto
    Double subtotal
    Double iva
    Double descuento
    Double total
    String ticket
    String comentarios
    Date cierreCajero
    Date cierreCaja
    Date cierreDia
    Date fechaMod
    String tipoVenta
    int enviado
    Date fecha

    SqtTienda tienda
    SqtUsuario usuarioMod
    SqtEstatus estatus
    SqtVenta venta
    SqtReembolso reembolso
    SqtListaPrecios listaPrecios

    static hasMany = [detalles:SqtDetalleDevolucionVenta]

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        ivaNeto nullable: true
        totalNeto nullable: true
        subtotal nullable: true
        iva nullable: true
        ticket maxSize: 2, nullable: true
        comentarios maxSize: 500, nullable: true
        cierreCajero nullable: true
        cierreCaja nullable: true
        cierreDia nullable: true
        tipoVenta maxSize: 3, nullable: true
        enviado notEqual: true
        fecha nullable: true
    }
}
