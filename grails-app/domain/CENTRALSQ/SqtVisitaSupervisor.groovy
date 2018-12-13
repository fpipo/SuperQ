package CENTRALSQ

class SqtVisitaSupervisor {
    Date llegada
    int enviado

    String  usuarioMod
    SqtTienda tienda
    SqtSupervisor supervisor


    static constraints = {
        usuarioMod maxSize: 30
        enviado nullable:true
    }
}
