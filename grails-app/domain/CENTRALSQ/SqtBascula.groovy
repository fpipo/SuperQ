package CENTRALSQ

class SqtBascula {
    String descripcion
    int digitos
    int enviado

    static constraints = {
        descripcion maxSize: 50, nullable: false
    }
}
