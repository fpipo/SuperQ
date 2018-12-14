package CENTRALSQ

class SqtProducto {
    String descripcionCorta
    String descripcionLarga
    String tipo
    int consignacion
    int inventariable
    int surteProveedor
    int surteBodega
    int aplicaA
    Double contenidoProducto
    Double cantidadProducto
    Double ultimoPrecioCompra
    Double ultimoMontoIva
    Double ultimoPctVarianza
    Double ultimoPcompraRegalo
    Double ultimoMivaRegalo
    Double pctCobro
    Double pctVenta
    String contenidoUnidad
    int prodTerminado
    int conCargo
    int completo
    int paraDevolucion
    Date fechamod
    int enviado
    int preinactivo
    int ta
    int esImporte
    int libreCmp
    int inactivoCompra
    int ventaConExis

    SqtMarca marca
    SqtCategoria categoria
    SqtUsuario usuarioMod
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    SqtUnidadMedida idUnidadMedidaC, unidadMedida
    SqtEstatus estatus
    SqtClasificacion clasificacion

    static constraints = {
        descripcionCorta maxSize:50
        descripcionLarga maxSize: 250
        tipo maxSize:3
        contenidoUnidad maxSize: 3, nullable: true
        enviado nullable:true
    }
}
