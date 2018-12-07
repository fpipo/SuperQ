package CENRALSQ

class SqtArea {
    String descripcion
    String centroCostos
    int enviado

    static constraints = {
        descripcion maxSize: 50
        centroCostos maxSize: 30
    }
}
