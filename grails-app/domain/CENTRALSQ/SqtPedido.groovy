package CENTRALSQ

class SqtPedido {
    String caja
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

    static constraints = {
    }
}
