package CENTRALSQ

class SqtImpuesto {
    String clave
    String descripcion
    Double valor
    String tipo
    String tipoImpuesto
    int ordenCierre
    String tipoMovimiento
    String tipoDescripcion
    String descripcionFactura
    int enviado

    static constraints = {
        clave maxSize: 2
        descripcion maxSize: 50, nullable:true
        ordenCierre nullable:true
        tipoImpuesto maxSize: 3, nullable:true
        tipoMovimiento maxSize: 3, nullable:true
        tipoDescripcion maxSize: 50, nullable:true
        descripcionFactura maxSize: 30, nullable:true
    }
}
