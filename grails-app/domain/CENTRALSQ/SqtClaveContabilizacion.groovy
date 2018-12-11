package CENTRALSQ

class SqtClaveContabilizacion {
    String descripcion
    String tipoMovimiento
    String tipoContabilizacion
    int enviado

    static constraints = {
        descripcion maxSize: 50
        tipoMovimiento maxSize: 1
        tipoContabilizacion maxSize: 1
        enviado nuluable: true
    }
}
