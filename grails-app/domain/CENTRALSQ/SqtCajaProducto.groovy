package CENTRALSQ

class SqtCajaProducto {
    int contenido
    int principal
    int enviado

    SqtProducto cogigo
    SqtUnidadMedida unidadMedida

    static constraints = {
        enviado nulable: true
    }
}
