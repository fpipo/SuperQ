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
    Date cierreCajero
    Date cierreCaja
    Date cierreDia
    String archivo
    SqtUsuario usuarioMod
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtCaja caja
    SqtEstatus estatus
    SqtProveedor proveedor
    SqtPoliza poliza
    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
    }
}
