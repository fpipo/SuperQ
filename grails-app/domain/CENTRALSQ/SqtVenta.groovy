package CENTRALSQ

class SqtVenta {
    String id
    Date diaOperacion
    String caja
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
    String tipoventa
    String comentarios
    Date cierrecajero
    Date cierrecaja
    Date cierredia
    SqtUsuario usuarioMod
    Date fechamod
    int enviado
    Date fecha

    SqtTienda tienda

    SqtListaPrecios listaPrecios
    SqtEstatus estatus
    SqtFactura factura



    static mapping = {
        id generator: 'uuid', name:'id'
    }
    static constraints = {
        caja maxSize:3
        comentarios maxSize: 3000
        enviado nullable:true


    }
}
