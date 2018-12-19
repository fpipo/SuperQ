package CENTRALSQ

class SqtFormatoServicio {
    SqtServicio servicio
    String idcampo
    int posiciones
    int orden
    String idEtiqueta
    int enviado

    static constraints = {
        posiciones nullable: true
        orden nullable: true
        idcampo maxSize: 30
        idEtiqueta maxSize: 10
        enviado nullable:true
    }
}
