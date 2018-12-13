package CENTRALSQ

class SqtInventarioCompensacionCategoria {

    int partida
    Double subtotal
    Double montoIva
    Double montoIsb
    Double total
    int pmaxima
    int enviado

    SqtTienda tienda
    SqtCategoria categoria
    SqtImpuesto impuesto

    static constraints = {
        enviado nullable:true
    }
}
