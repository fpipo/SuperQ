package CENTRALSQ

class SqtHistoricoPrecio {
    Date fechaInicio
    Date fechaFin
    Double precioCompraSiva
    Double montoIvaPrecioCompra
    int aplicaPcompraOferta
    Double pcompraOfertaCiva
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
    String  usuarioMod
    Double montoIsb

    SqtListaPrecios listaPrecios
    SqtProveedor proveedor
    SqtProducto producto

    static constraints = {
        fechaFin nullable:true
        precioCompraSiva nullable:true
        montoIvaPrecioCompra nullable:true
        aplicaPcompraOferta nullable:true
        pcompraOfertaCiva nullable:true
        mIvaPcompraOferta nullable:true
        precioVentaNormal nullable:true
        margenUtilidadNormal nullable:true
        precioVentaSiva nullable:true
        sugerido nullable:true
        precioSugerido nullable:true
        montoIvaPrecioSugerido nullable:true
        margenUtilidadSugerido nullable:true
        sugeridoPor maxSize: 2, nullable:true
        pctVarianza nullable:true
        montoIsb nullable:true
    }
}
