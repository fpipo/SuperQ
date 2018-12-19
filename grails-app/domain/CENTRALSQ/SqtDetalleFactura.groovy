package CENTRALSQ

class SqtDetalleFactura {
    int partida
    Double cantidad
    String descripcion
    Double precioUnitario
    Double subtotal
    Double montoIva
    int unidadesFs
    int imprimir
    int enviado
    Double montoIsb
    String catSat

    SqtFactura factura
    SqtTienda tienda
    SqtUnidadMedida unidadMedida
    SqtImpuesto impuesto
    SqtMovimiento movimiento

    static belongsTo = [facturas:SqtFactura]

    static constraints = {
        cantidad nullable: true
        unidadMedida nullable: true
        descripcion maxSize: 50, nullable: true
        precioUnitario nullable: true
        subtotal nullable: true
        montoIva nullable: true
        unidadesFs nulluable: true
        imprimir nulluable: true
        catSat maxSize: 50, nullable: true
        enviado nulluable: true
    }
}
