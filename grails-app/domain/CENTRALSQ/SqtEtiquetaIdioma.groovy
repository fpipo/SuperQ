package CENTRALSQ

class SqtEtiquetaIdioma {
    String texto
    int enviado

    SqtIdioma idioma
    SqtFuncion funcion

    static constraints = {
        texto maxSize: 250, nullable: true
        enviado notEqual: true
    }
}
