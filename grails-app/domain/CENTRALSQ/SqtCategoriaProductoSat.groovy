package CENTRALSQ

class SqtCategoriaProductoSat {

    SqtProducto producto
    int claveProdser
    int enviado
    SqtEstatus estatus

    static constraints = {
        enviado nullable:true
    }
}
