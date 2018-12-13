package CENTRALSQ

class SqtHistoricoOferta {


    Date fechaInicio
    Date fechaFin
    Double precioCompraCiva
    Double montoivaPrecioCompra
    Double margenUtilidad
    Double pctDescuento
    Double montoDescuento
    Double precioVentaSiva
    Double montoivaPrecioVenta
    Double precioVentaCiva
    int aplicaOferta
    Date fechaMod
    String usuarioMod
    SqtListaPrecios listaPrecios
    SqtProveedor proveedor
    SqtProducto producto



    static constraints = {

        usuarioMod maxSize: 15


    }
}
