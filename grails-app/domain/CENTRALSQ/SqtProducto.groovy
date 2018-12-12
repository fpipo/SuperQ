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
    Double cantidadProducto
    Double ultimoPrecioCompra
    Double ultimoMontoIva
    Double ultimoPctVarianza
    Double ultimoPcompraRegalo
    Double ultimoMivaRegalo
    String contenidoUnidad
    Double pctCobro
    Double pctVenta
    int prodTerminado
    int conCargo
    int completo
    int paraDevolucion
    Date fechamod
    SqtUsuario usuarioMod
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


    static constraints = {

        enviado nullable:true

    }
}
