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
    SqtEstado estado
    SqtPais pais
    SqtTelefono telefono
    SqtEstatus estatus
    SqtTienda tienda
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
        email maxSize: 50, nullable: true
    }
}
