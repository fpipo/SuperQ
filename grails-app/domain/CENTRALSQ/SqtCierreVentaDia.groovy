package CENTRALSQ

class SqtCierreVentaDia {
    Date fecha
    String descripcionProducto
    String promPaq
    String indicadorIva
    Double uVendidas
    Double uDevueltas
    Double pVenta
    Double ventaBruta
    Double devolucion
    Double vbdIsb
    Double descuento
    Double ventaNeta
    Double montoIsb
    Double iva
    Double total
    int categoria
    int grupo
    int suerteBodega
    String preinactivo
    int prmPaq
    Double uVendidasPaqPrm

    SqtTienda tienda
    SqtEstatus estatus
    SqtProveedor proveedor
    SqtProducto producto

    static constraints = {
        promPaq maxSize: 100
        indicadorIva maxSize: 3
        preinactivo maxSize: 3, nullable: true
    }
}