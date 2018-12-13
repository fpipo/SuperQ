package CENTRALSQ

class SqtSupervisor {

    String nombre
    int enviado

    static constraints = {

        nombre maxSize: 100
        enviado nullable:true

    }
}
