package CENTRALSQ

class SqtMapeoProducto {


    Date fechaInicio
    String  usuarioMod
    Date fechaMod
    int enviado

    SqtProducto productoOrigienal
    SqtProducto productoSustituto
    SqtEstatus estatus

    static constraints = {
        enviado nullable:true
    }
}
