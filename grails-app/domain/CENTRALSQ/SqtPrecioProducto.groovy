package CENTRALSQ

class SqtPrecioProducto {
    Date fechaInicio
    Date fechaFin
    int aplicaPcompraOferta
    Double pcompraOfertaSiva
    Double mIvaPcompraOferta
    Double precio
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
        pcompraOfertaSiva nullable: true
        mIvaPcompraOferta nullable: true
        pctVarianza nullable: true
        montoIsb nullable: true
        enviado nullable:true
    }
}
