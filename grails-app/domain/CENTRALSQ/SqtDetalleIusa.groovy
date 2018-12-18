package CENTRALSQ

class SqtDetalleIusa {
    SqtTienda tienda
    SqtVenta venta
    Double cantidad
    String concepto
    Double monto
    Double iva
    String referencia

    static constraints = {
        monto nullable: true
        iva nullable:  true
        referencia maxSize: 150, nullable: true
    }
}
