package CENTRALSQ

class SqtImpuesto {
    String id
    String descripcion
    Double valor
    String tipo
    String tipoImpuesto
    int ordenCierre
    String tipoMovimiento
    String tipoDescripcion
    String descripcionFactura
    int enviado

    SqtTienda tienda
    SqtUsuario usuario
    SqtEstatus estatus
    SqtFactura factura
    SqtPoliza poliza


    static mapping = {
        id generator: 'uuid', name:'id'
    }
    static constraints = {
        descripcion maxSize: 50
        tipoMovimiento maxSize: 2
        tipoDescripcion maxSize: 50
        descripcionFactura maxSize: 30
    }
}
