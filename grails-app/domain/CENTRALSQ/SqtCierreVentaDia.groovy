package CENTRALSQ

class SqtCierreVentaDia {
    Date fecha
    String tienda
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


    SqtEstatus estatus
    SqtProveedor proveedor
    SqtProducto producto

    static constraints = {
        tienda maxSize: 8000 , nullable:true
        fecha nullable: true
        producto nullable: true
        descripcionProducto maxSize: 8000 , nullable: true
        promPaq maxSize: 100 , nullable: true
        indicadorIva maxSize: 3 , nullable: true
        uDevueltas nullable: true
        uDevueltas nullable: true
        pVenta nullable: true
        ventaBruta nullable: true
        devolucion nullable: true
        vbdIsb nullable: true
        descuento nullable: true
        ventaNeta nullable: true
        montoIsb nullable: true
        iva nullable: true
        categoria nullable:true
        grupo nullable:true
        proveedor nullable: true
        suerteBodega nullable:true
        estatus nullable: true
        uVendidasPaqPrm nullable: true
        prmPaq nullable:true
        preinactivo maxSize: 3, nullable: true
    }
}

/* Solo para CENTRALSQ*/
