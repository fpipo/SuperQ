package CENTRALSQ

class SqtCatalogoGlasgo {
    int compra
    int venta
    int enviado

    SqtProducto producto
    SqtEstatus estatus

    static constraints = {
        enviado nullable: true
    }
}
