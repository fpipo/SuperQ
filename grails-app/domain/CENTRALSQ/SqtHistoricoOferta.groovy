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
    Double montoIvaPrecioVenta
    Double precioVentaCiva
    int aplicaOferta
    Date fechaMod

    SqtUsuario usuarioMod
    SqtListaPrecios listaPrecios
    SqtProveedor proveedor
    SqtProducto producto

    static constraints = {
        fechaFin nullable:true
        montoivaPrecioCompra nullable:true
        margenUtilidad nullable:true
        pctDescuento nullable:true
        montoDescuento nullable:true
        precioVentaSiva nullable:true
        montoIvaPrecioVenta nullable:true
        precioVentaCiva nullable:true
        precioCompraCiva nullable:true
        aplicaOferta nullable:true
    }
}
