package CENTRALSQ

class SqtPreciosOferta {

    Date fechaInicio
    Date fechaFin
    Double precioCompraCiva
    Double montoIvaPrecioCompra
    Double precioCompraSiva
    Double pventaNormalSiva
    Double mIvaPventoNormal
    Double pventaNormalCiva
    Double margenUtilidadNormal
    Double pctDescuento
    Double descuentoSiva
    Double montoIvaDescuento
    Double descuentoCiva
    Double precioVentaSiva
    Double montoIvaPrecioVenta
    Double montoFs
    Double precioVentaCiva
    Double margenUtilidad
    int aplicaOferta
    Date fechaMod
    String usuarioMod
    int enviado
    Double montoIsb

    SqtListaPrecios listaPrecios
    SqtProveedor proveedor
    SqtProducto producto
    SqtEstatus estatus


    static constraints = {
        usuarioMod maxSize: 15
        enviado nullable:true


    }
}
