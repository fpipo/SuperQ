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
    Double montoFs
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

        sugeridoPor maxSize: 2
        usuarioMod maxSize: 15
    }
}
