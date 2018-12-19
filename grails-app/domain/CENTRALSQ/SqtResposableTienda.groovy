package CENTRALSQ

class SqtResposableTienda {

    SqtTienda tienda
    SqtUsuario usuario
    Date fechaInicio
    Date fechaFin
    int enviado

    static constraints = {
        fechaFin nullable: true
        enviado nullable:true

    }
}
