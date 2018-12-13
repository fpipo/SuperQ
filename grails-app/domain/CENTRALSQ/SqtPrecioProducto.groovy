package CENTRALSQ

class SqtPrecioProducto {
    Date fechaInicio
    Date fechaFin
    Double precioCompraSiva
    Double montoIvaPrecioCompra
    int aplicaPcompraOferta
    Double pcompraOfertaSiva
    Double mIvaPcompraOferta
    Double precioVentaNormal
    Double margenUtilidadNormal
    Double precioVentaSiva
    Double montoIvaPrecioVenta
    Double montoFs
    Double precioVentaCiva
    int sugerido
    Double precioSugerido
    Double montoIvaPrecioSugerido
    Double margenUtilidadSugerido
    String sugeridoPor
    Double pctVarianza
    Date fechaMod
    int enviado
    Double montoIsb

    SqtUsuario usuarioMod
    SqtListaPrecios listaPrecios
    SqtProveedor proveedor
    SqtProducto producto

    static constraints = {
        enviado nullable:true
    }
}
