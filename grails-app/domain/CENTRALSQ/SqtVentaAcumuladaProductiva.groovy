package CENTRALSQ

class SqtVentaAcumuladaProductiva {

    SqtTienda tienda
    String clasificacion
    String jefeOperaciones
    String supervisor
    int producto
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

    SqtTienda idTienda
    SqtSegmentos segmento


    static constraints = {
        tienda maxSize:150
        clasificacion maxSize: 150
        jefeOperaciones maxSize: 100
        supervisor maxSize: 100
        descripcionProducto maxSize: 200
        tipo maxSize: 50
        categoria maxSize: 100
        grupo maxSize: 100
        proveedor maxSize: 200
        servicioComercial maxSize: 200
        almacen maxSize: 100

    }
}
