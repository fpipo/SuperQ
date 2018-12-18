package CENTRALSQ

class SqtInventarioCompensacionCategoria {
    int partida
    Double subtotal
    Double montoIva
    Double montoIsb
    Double total
    int pmaxima
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtImpuesto impuesto

    static constraints = {
        subtotal nullable:true
        montoIva nullable:true
        montoIsb nullable:true
        total nullable:true
        pmaxima nullable:true
        enviado nullable:true
    }
}
