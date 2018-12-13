package CENTRALSQ

class SqtDevolucion {

    String id
    Date fecha
    Double subtotal
    Double iva
    Double total
    String comentarios
    int impresion
    Date fechaMod
    int enviado

    SqtProveedor proveedor
    SqtTienda tienda
    SqtMovimiento movimiento
    SqtCaja caja
    SqtEstatus estatus
    SqtPedido pedido
    SqtPoliza poliza
    SqtTransaccion transaccion
    SqtUsuario usuarioMod
    SqtFactura factura

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        comentarios maxSize: 500
        enviado nullable:true
        usuarioMod nullable: false
    }
}
