package CENTRALSQ

class SqtDetalleIusa {
    int cantidad
    String concepto
    Double monto
    Double iva
    String referencia
    SqtTienda tienda
    SqtVenta venta

    static constraints = {
        concepto maxSize: 150, nullable: false
    }
}
