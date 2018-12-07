package CENTRALSQ

class SqtRuta {
    String descripcion
    int lunes
    int martes
    int miercoles
    int jueves
    int viernes
    int sabado
    int domingo
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: false
    }
}
