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
    String referenciaFrog
    Date fechaMod
    int enviado

    SqtArchivo archivo
    SqtUsuario usuarioMod
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

    static hasMany = [pedido:SqtDetallePedido]

    static constraints = {
        comentarios maxSize: 255, nullable: true
        numFactura maxSize: 30, nullable: true
        numRemision maxSize: 30, nullable: true
        enviado nullable:true
        fechaMod nullable: true
        fechaCierre nullable: true
        fechaProceso nullable: true
        iva  nullable: true
        totalFactura  nullable: true
        tipoPedido nullable: true
        tipoPrecio nullable: true
        referenciaPedido nullable: true
        poliza  nullable: true
        cierreCajero  nullable: true
        cierreCaja  nullable: true
        cierreDia nullable: true
        referenciaFrog maxSize: 30, nullable: true
        transaccion nullable:true
        archivo nullable:true
    }
}
