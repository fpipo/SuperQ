package CENTRALSQ

class SqtIdioma {
    String descripcion
    int enviado

    static constraints = {
        descripcion maxSize: 30
        enviado notEqual: true
    }
}
