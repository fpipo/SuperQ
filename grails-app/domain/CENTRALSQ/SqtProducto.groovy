package CENTRALSQ

class SqtProducto {
    String descripcionCorta
    String descripcionLarga
    String tipo
    int consignacion
    int inventariable
    int surteProveedor
    int aplicaA
    Double contenidoProducto
    String idUnidadMedida
    Double cantidadProducto
    String idclasificacion
    Double ultimoPrecioCompra
    Double ultimoMontoIva
    Double ultimoPctVarianza
    Double ultimoPcompraRegalo
    Double ultimoMivaRegalo
    String idUnidadMedidaC
    String contenidoUnidad
    Double pctCobro
    Double pctVenta
    int prodTerminado
    int conCargo
    int completo
    int paraDevolucion
    Date fechamod
    String usuarioMod
    int enviado
    int preinactivo
    int ta
    int esImporte
    int libreCmp
    int inactivoCompra
    int ventaConExis

    SqtMarca marca
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    SqtUnidadMedida unidadMedida
    SqtEstatus estatus



    static constraints = {

        descripcionCorta maxSize:50
        descripcionLarga maxSize: 250
        tipo maxSize:3
        idUnidadMedida maxSize: 3
        idclasificacion maxSize: 2
        idUnidadMedidaC maxSize: 3
        contenidoUnidad maxSize: 3
        usuarioMod maxSize: 15
        enviado nullable:true

    }
}
