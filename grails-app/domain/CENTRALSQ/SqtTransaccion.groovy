package CENTRALSQ

class SqtTransaccion {
    String descripcion
    int enviado
    SqtFuncion funcion

    static constraints = {
        descripcion maxSize: 250
        enviado nullable:true
    }
}
