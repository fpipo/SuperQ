package CENTRALSQ

class SqtImpuesto {
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
        descripcion maxSize: 50
        tipoMovimiento maxSize: 2
        tipoDescripcion maxSize: 50
        descripcionFactura maxSize: 30
    }
}
