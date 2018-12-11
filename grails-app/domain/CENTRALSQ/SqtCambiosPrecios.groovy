package CENTRALSQ

class SqtCambiosPrecios {
    Double precio
    Date fechaMod
    int enviado

    SqtListaPrecios listaPrecios
    SqtProducto producto
    SqtEstatus estatus

    static constraints = {
        enviado nuluable: true
    }
}
