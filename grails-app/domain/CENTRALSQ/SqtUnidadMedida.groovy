package CENTRALSQ

class SqtUnidadMedida {
    String descCorta
    String descripcion
    double conversion
    int visible
    int enviado

    static constraints = {
        descCorta maxSize: 3
        descripcion maxSize: 50
    }
}
