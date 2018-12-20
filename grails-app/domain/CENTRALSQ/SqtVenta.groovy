package CENTRALSQ

class SqtVenta {
    String id
    Date diaOperacion
    Double ivaNeto
    Double totalNeto
    Double subtotal
    Double iva
    Double descuento
    Double totalProducto
    Double totalServicio
    Double granTotal
    Double granTotalRedondeado
    String ticket
    String tipoVenta
    String comentarios
    Date cierreCajero
    Date cierreCaja
    Date cierreDia
    SqtUsuario usuarioMod
    Date fechaMod
    int enviado
    Date fecha

    SqtTienda tienda
    SqtListaPrecios listaPrecios
    SqtEstatus estatus
    SqtFactura factura

    static hasMany = [ventaP:SqtDetalleVentaProducto, ventaS:SqtDetalleVentaServicio]

    static mapping = {
        id generator: 'uuid', name:'id'
    }
    static constraints = {
        ivaNeto nullable: true
        totalNeto nullable: true
        subtotal nullable: true
        iva nullable: true
        descuento nullable: true
        totalProducto nullable: true
        totalServicio nullable: true
        ticket maxSize: 2, nullable: true
        tipoventa maxSize: 3
        comentarios maxSize: 3000, nullable: true
        cierreCajero nullable: true
        cierreDia nullable: true
        cierreCaja nullable: true
        enviado nullable:true
        factura nullable: true
        fecha nullable: true
    }
}
