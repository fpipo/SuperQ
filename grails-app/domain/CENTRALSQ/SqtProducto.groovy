package CENTRALSQ

class SqtProducto {
    String idArticulo
    String descripcionCorta
    String descripcionLarga
    String tipo
    int consignacion
    int inventariable
    int surteProveedor
    int surteBodega
    int aplicaA
    Double contenidoProducto
    String unidadMedidaContenido
    Double cantidadProducto
    Double ultimoPrecioCompra
    Double ultimoMontoIva
    Double ultimoPctVarianza
    Double ultimoPcompraOferta
    Double ultimoPcompraRegalo
    Double ultimoMivaRegalo
    Double pctCobro
    Double pctVenta
    String contenidoUnidad
    int prodTerminado
    int conCargo
    int completo
    int paraDevolucion
    Date fechaMod
    int enviado
    int preinactivo
    int ta
    int idCompania
    int esImporte
    String idTiempoAire
    int libreCmp
    int inactivoCompra
    int inactivoCedisComisariato

    SqtMarca marca
    SqtCategoria categoria                      /* Vendra de SAP */
    SqtUsuario usuarioMod
    SqtGrupo grupo                              /* Vendra de SAP */
    SqtSubgrupo subgrupo                        /* Vendra de SAP */
    SqtUnidadMedida unidadMedida
    SqtEstatus estatus

    static constraints = {
        idArticulo maxSize: 18, nullable: true   /* Vendra de SAP*/
        descripcionCorta maxSize: 50
        descripcionLarga maxSize: 40, nullable: true   /* Vendra de SAP */
        tipo maxSize:3
        marca nullable: true                            /* Vendra de SAP */
        consignacion nullable: true
        inventariable nullable: true
        surteProveedor nullable: true
        surteBodega nullable: true
        aplicaA nullable: true
        contenidoUnidad nullable: true
        unidadMedidaContenido maxSize: 3 , nullable: true
        cantidadProducto nullable: true
        ultimoPrecioCompra nullable: true
        ultimoMontoIva nullable: true
        ultimoPctVarianza nullable: true
        ultimoPcompraOferta nullable: true
        ultimoMivaRegalo nullable: true
        pctCobro nullable: true
        pctVenta nullable: true
        prodTerminado nullable: true
        conCargo nullable: true
        paraDevolucion nullable: true
        preinactivo nullable: true
        ta nullable: true
        idCompania nullable: true
        idTiempoAire maxSize: 14 , nullable: true
        libreCmp nullable: true
        inactivoCompra nullable: true
        esImporte nullable: true
        contenidoUnidad maxSize: 3, nullable: true
        enviado nullable:true
        inactivoCedisComisariato nullable:  true
    }
}
