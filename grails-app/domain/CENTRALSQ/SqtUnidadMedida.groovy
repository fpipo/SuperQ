package CENTRALSQ

class SqtUnidadMedida {
    String clave
    String descripcion
    double conversion
    int visible
    int enviado

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50
        visible nullable: true
        enviado nullable:true
    }
}
