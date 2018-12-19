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
        fechaFin nullable: true
        precioCompraSiva nullable: true
        montoIvaPrecioCompra nullable: true
        pcompraOfertaSiva nullable: true
        mIvaPcompraOferta nullable: true
        precioVentaNormal nullable: true
        margenUtilidadNormal nullable: true
        sugerido nullable: true
        precioSugerido nullable: true
        montoIvaPrecioSugerido nullable: true
        margenUtilidadSugerido nullable: true
        sugeridoPor nullable: true
        pctVarianza nullable: true
        montoIsb nullable: true
        enviado nullable:true
    }
}
