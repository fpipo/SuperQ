package CENTRALSQ

class SqtCliente {
    String nombre
    String aPaterno
    String aMaterno
    String rfc
    String razonSocial
    String calle
    String colonia
    String municipio
    String cp
    String ciudad
    String email
    Date fechaMod
    int enviado
    String numInt
    String numExt
    String telefono
    String cel

    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtTipo tipoCliente

    static constraints = {
        nombre maxSize: 50, nullable: true
        aPaterno maxSize: 50, nullable: true
        aMaterno maxSize: 50, nullable: true
        rfc maxSize: 15, nullable: true
        razonSocial maxSize: 50, nullable: true
        calle maxSize: 50, nullable: true
        colonia maxSize: 50, nullable: true
        municipio maxSize: 50, nullable: true
        cp maxSize: 5, nullable: true
        ciudad axSize: 50, nullable: true
        pais nullable: true
        estado nullable: true
        telefono nullable: true
        email email: true, maxSize: 50, nullable: true
        enviado nullable: true
        numInt maxSize: 10, nullable: true
        numExt maxSize: 10, nullable: true
        telefono maxSize: 10, nullable: true
        cel maxSize: 10, nullable: true
    }
}
