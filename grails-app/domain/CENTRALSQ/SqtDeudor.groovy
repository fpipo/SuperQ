package CENTRALSQ

class SqtDeudor {
    String nombre
    String rfc
    Date fechaMod
    int enviado
    String subCuenta
    SqtUsuario usuarioMod
    SqtTipo tipo
    SqtCliente cliente

    static constraints = {
        nombre maxSize: 70, nullable: false
        rfc maxSize: 13
    }
}
