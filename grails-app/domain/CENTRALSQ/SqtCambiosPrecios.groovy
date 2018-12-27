package CENTRALSQ

class SqtCambiosPrecios {
    Double precio
    Date fechaMod
    int enviado

    SqtListaPrecios listaPrecios
    SqtProducto producto
    SqtEstatus estatus

    static constraints = {
        enviado nullable: true
        estatus nullable: true
    }
}
