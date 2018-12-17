package CENTRALSQ

class SqtCatalogoTostato {
    SqtProducto producto
    SqtEstatus estatus
    int enviado

    static constraints = {

        enviado nullable:true

    }
}
