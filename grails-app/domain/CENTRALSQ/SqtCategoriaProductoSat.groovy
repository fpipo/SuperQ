package CENTRALSQ

class SqtCategoriaProductoSat {

    SqtProducto producto
    int claveProdser
    int enviado
    SqtEstatus estatus

    static constraints = {
        producto nullable:true
        claveProdser nullable:true
        estatus nullable: true
        enviado nullable:true
    }
}
