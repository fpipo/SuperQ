package CENTRALSQ

class SqtFolioe {
    String serie
    int generado
    Date fechaMod
    int enviado

    SqtFactura factura
    SqtTienda tienda
    SqtFolio folio
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        generado nullable:true
        enviado nullable:true
    }
}
