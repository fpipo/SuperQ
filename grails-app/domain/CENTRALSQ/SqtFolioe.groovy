package CENTRALSQ

class SqtFolioe {

    String serie
    int generado
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtFolio folio
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable:true



    }
}
