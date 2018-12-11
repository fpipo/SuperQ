package CENTRALSQ

class SqtAjusteProducto {
    int conCargo
    Double pctCobro
    Double pctVenta
    int enviado

    SqtMovimiento movimiento
    SqtProducto producto

    static constraints = {
        pctCobro nullable: true
        conCargo nullable:true
        pctVenta nullable:true
        enviado nullable:true
    }
}
