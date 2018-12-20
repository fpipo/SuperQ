package CENTRALSQ

class SqtMapeoProducto {
    Date fechaInicio
    String  usuarioMod
    Date fechaMod
    int enviado

    SqtProducto productoOrigienal, productoSustituto
    SqtEstatus estatus

    static constraints = {
        enviado nullable:true
        usuarioMod nullable:true
        fechaMod nullable: true
    }
}
