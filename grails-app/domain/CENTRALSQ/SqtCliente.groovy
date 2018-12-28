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
    int numInt
    int numExt
    String telefono

    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtTipo tipoCliente
    SqtTienda tienda

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
        tienda nullable: true
        numInt nullable: true
        numExt nullable: true
        telefono maxSize: 10, nullable: true
    }
}
