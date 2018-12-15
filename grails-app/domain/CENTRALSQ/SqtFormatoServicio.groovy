package CENTRALSQ

class SqtFormatoServicio {
    SqtServicio servicio
    String idcampo
    int posiciones
    int odern
    String idEtiqueta
    int enviado

    static constraints = {
        idcampo maxSize: 30
        idEtiqueta maxSize: 10
        enviado nullable:true

    }
}
