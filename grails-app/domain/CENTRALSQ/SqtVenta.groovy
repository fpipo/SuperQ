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

    static mapping = {
        id generator: 'uuid', name:'id'
    }
    static constraints = {
    }
}
