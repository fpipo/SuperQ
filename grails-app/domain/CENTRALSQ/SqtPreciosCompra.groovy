package CENTRALSQ

class SqtPreciosCompra {

    Date fechaAplica
    Double precioCompra
    Double precioCompraSiva
    Double precioOferta
    Double precioRegalo
    Double pctIva
    Double pctIvaOferta
    Double pctIvaRegalo
    Double ivaPrecioCompra
    Double ivaPecioOferta
    Double ivaPrecioRegalo
    int aplicaSugerido
    Double precioSugerido
    Double pctVarianza
    int aplicaPrecioCompra
    Double montoFs
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    SqtProveedor proveedor
    SqtProducto producto
    SqtGrupoTienda grupoTienda



    static constraints = {
        enviado nullable:true

    }
}
