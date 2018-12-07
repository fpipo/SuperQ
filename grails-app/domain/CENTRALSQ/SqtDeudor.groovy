package CENTRALSQ

class SqtDeudor {
    String nombre
    String rfc
    Date fechaMod
    int enviado
    String subCuenta
    int conbinacion
    SqtUsuario usuarioMod
    SqtTipo tipo
    SqtCliente cliente
    SqtCondicionPago condicionPago
    SqtEstatus estatus

    static constraints = {
        nombre maxSize: 70
        rfc maxSize: 13, nullable: true
        subcuenta maxSize: 5, nullable: true
        usuarioMod nullable: false
    }
}
