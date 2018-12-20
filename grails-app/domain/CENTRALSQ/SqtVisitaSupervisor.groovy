package CENTRALSQ

class SqtVisitaSupervisor {
    Date llegada
    int enviado

    SqtUsuario usuarioMod
    SqtTienda tienda
    SqtSupervisor supervisor

    static constraints = {
        enviado nullable:true
    }
}
