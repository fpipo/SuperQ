package CENTRALSQ

class SqtDetalleDevolucion {
    Double precioSiva
    Double ivaPrecio
    Double cantidad
    Double iva
    Double subtotal
    Double total
    Double cantidadPresentacion
    String presentacion
    int enviado

    SqtDevolucion devolucion
    SqtTienda tienda
    SqtProducto producto
    SqtMovimiento movimiento
    SqtUnidadMedida unidadMedida

    static  belongsTo = [devolucion:SqtDevolucion]
    static constraints = {
        presentacion maxSize: 50

    }
}
