package CENTRALSQ

class SqtTranTdc {
    Date diaOperacion
    Date fechaMod
    int enviado

    SqtTienda tienda

    static constraints = {
        enviado nullable:true
    }
}
