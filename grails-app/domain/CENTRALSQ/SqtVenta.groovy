package CENTRALSQ

class SqtVenta {

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
    String usuariomod
    Date fechamod
    String usuarioAutorizacion
    int enviado
    Date fecha

    static mapping = {
        id generator: 'uuid'
    }
    static constraints = {
    }
}
