package CENTRALSQ

class SqtClaveContabilizacion {
    String descripcion
    String tipoMovimiento
    String tipoContabilizacion
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: false
        tipoMovimiento maxSize: 1, nullable: false
        tipoContabilizacion maxSize: 1
    }
}
