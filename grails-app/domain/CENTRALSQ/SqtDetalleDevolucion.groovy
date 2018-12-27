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

    SqtTienda tienda
    SqtProducto producto
    SqtMotivoDevolucion motivoDevolucion
    SqtUnidadMedida unidadMedida

    static  belongsTo = [devolucion:SqtDevolucion]

    static constraints = {
        presentacion maxSize: 50 ,nullable: true
        precioSiva nullable: true
        ivaPrecio nullable: true
        cantidadPresentacion nullable: true
        iva nullable: true
        motivoDevolucion nullable: true
        unidadMedida nullable: true
        enviado nullable: true
    }
}
