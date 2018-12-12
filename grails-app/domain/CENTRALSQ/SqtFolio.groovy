package CENTRALSQ

class SqtFolio {

    String serie
    int folio
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtUsuario usuarioMod
    static constraints = {
        serie maxSize: 2
        enviado nullable:true
    }
}
