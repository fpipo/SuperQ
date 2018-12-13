package CENTRALSQ

class SqtUnidadMedida {
    String descCorta
    String descripcion
    double conversion
    int visible
    int enviado

    static constraints = {
        descCorta maxSize: 3, nullable: false
        descripcion maxSize: 50, nullable: false
        enviado nullable:true
    }
}
