package CENTRALSQ

class SqtUsuario {
    String nombre
    String aPaterno
    String aMaterno
    String calle
    String colonia
    String municipio
    String cp
    String ciudad
    String  email
    Date fechaMod
    int numIntentos
    String enviado
    Date fechaNacimiento
    String seguroSocial
    String curp
    String rfc
    String numInterior
    String numExterior
    String entidadNac
    String estadoCivil
    String regimen
    Genero genero
    String estudios
    String infonavit
    String cuentaBancaria
    Date fechaRegistro
    int noEmpleado
    String foto

    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtAcreedor acreedor
    SqtDeudor  deudor
    SqtCliente cliente

    static mapping = {
        genero enumType: 'ordinal'
    }

    static constraints = {
        nombre maxSize: 50
        aPaterno maxSize: 50
        aMaterno maxSize: 50
        calle maxSize: 50
        colonia maxSize: 50
        municipio maxSize: 50
        cp maxSize: 50
        ciudad maxSize: 50
        email email: true
        seguroSocial maxSize: 50
        curp maxSize: 50
        rfc maxSize: 50
        numInterior maxSize: 10
        numExterior maxSize: 20
        entidadNac maxSize: 100
        estadoCivil maxSize: 50
        regimen maxSize: 50
        estudios maxSize: 50
        infonavit maxSize: 5
        cuentaBancaria maxSize: 30
    }
}
