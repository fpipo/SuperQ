package CENTRALSQ

class SqtCajaProducto {
    int contenido
    int principal
    int enviado

    SqtUnidadMedida unidadMedida

    static belongsTo = [producto:SqtProducto]

    static constraints = {
        enviado nulable: true
        contenido nulable: true
        unidadMedida nulable: true
    }
}
