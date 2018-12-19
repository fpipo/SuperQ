package CENTRALSQ

class SqtVentaAcumuladaProductiva {
    Date fecha
    String clasificacion
    String jefeOperaciones
    String supervisor
    int prmPaq
    String descripcionProducto
    String tipo
    String categoria
    String grupo
    String proveedor
    String servicioComercial
    String almacen
    Double unidades
    Double unidadesPqm
    Double precioVenta
    Double ventaNeta

    SqtTienda tienda
    String segmento
    SqtProducto producto

    static constraints = {
        clasificacion maxSize: 150, nullable: true
        jefeOperaciones maxSize: 100, nullable: true
        supervisor maxSize: 100, nullable: true
        descripcionProducto maxSize: 200
        tipo maxSize: 50, nullable: true
        prmPaq nullable: true
        categoria maxSize: 100, nullable: true
        grupo maxSize: 100, nullable: true
        proveedor maxSize: 200, nullable: true
        servicioComercial maxSize: 200, nullable: true
        almacen maxSize: 100, nullable: true
        unidades nullable: true
        unidadesPqm nullable: true
        precioVenta nullable: true
        ventaNeta nullable: true
        segmento maxSize: 100, nullable: true
    }
}
