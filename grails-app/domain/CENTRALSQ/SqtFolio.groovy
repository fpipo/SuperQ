package CENTRALSQ

class SqtFolio {

    String serie
    int folio
    Date fechaMod
    int enviado

    SqtFactura factura
    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        serie maxSize: 2
        enviado nullable:true
    }
}
