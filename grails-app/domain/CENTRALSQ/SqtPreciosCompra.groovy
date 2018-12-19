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
    Date fechaMod
    SqtUsuario usuarioMod
    int enviado

    SqtProveedor proveedor
    SqtProducto producto
    SqtGrupoTienda grupoTienda



    static constraints = {


        precioCompra nullable: true
        precioCompraSiva nullable: true
        precioOferta nullable: true
        precioRegalo nullable: true
        pctIvaOferta nullable: true
        pctIvaRegalo nullable: true
        ivaPrecioCompra nullable: true
        ivaPecioOferta nullable: true
        ivaPrecioRegalo nullable:true
        aplicaSugerido nullable: true
        precioSugerido nullable: true
        pctVarianza nullable: true
        aplicaPrecioCompra nullable: true
        fechaMod nullable: true
        usuarioMod nullable: true
        enviado nullable:true

    }
}
