package CENTRALSQ

class SqtImpuestoProducto {

    Double contenidoProducto
    Double monto
    int aplica
    int iva
    int fs
    int ivaCompra
    int enviado
    int isb

    SqtProducto producto

    static constraints = {

        enviado nullable:true

    }
}
