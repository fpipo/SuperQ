package CENTRALSQ

class SqtPedido {
    String id
    Date fechaProceso
    Date fechaCierre
    Double subtotal
    Double iva
    Double total
    Double totalFactura
    String tipoPedido
    String tipoPrecio
    String tipo
    String comentarios
    String numFactura
    String numRemision
    Date cierreCajero
    Date cierreCaja
    Date cierreDia
    String archivo
    SqtUsuario usuarioMod
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtCaja caja
    SqtMovimiento movimiento
    SqtEstatus estatus
    SqtProveedor proveedor
    SqtPoliza poliza
    SqtPedido referenciaPedido
    SqtTransaccion transaccion


    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static hasMany = [pedido:SqtDetallePedido, parcial:SqtDetalleParcial]

    static constraints = {

        comentarios maxSize: 255
        numFactura maxSize: 30
        numRemision maxSize: 30
        archivo maxSize: 30
        enviado nullable:true
    }
}
