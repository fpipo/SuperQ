package CENTRALSQ

class SqtAcreedor {
    String nombre
    String rfc
    String responsable
    String responsableTel
    String responsableEmail
    Date fechaMod
    int enviado

    SqtTipo tipo
    SqtEstatus estatus
    SqtCondicionPago condicionPago
    SqtUsuario usuarioMod

    static constraints = {
        nombre maxSize: 70
        rfc maxSize: 13, nullable: true
        responsable maxSize: 15, nullable: true
        responsableTel maxSize: 30, nullable: true
        responsableEmail email: true, maxSize: 130, nullable: true
        enviado nullable:true
        condicionPago nullable: true
    }
}
