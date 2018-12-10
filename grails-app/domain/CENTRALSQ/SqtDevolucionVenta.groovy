package CENTRALSQ

class SqtDevolucionVenta {
    String id
    Date diaOperacion
    String caja
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
    Date fechamod
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
        comentarios maxSize: 500, nullable: true
        tipoVenta maxSize: 3, nullable: true
    }
}
