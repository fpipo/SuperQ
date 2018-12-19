package CENTRALSQ

class SqtUsuario {
    String username
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
    int enviado
    Date fechaNacimiento
    String seguroSocial
    String curp
    String rfc
    String numInterior
    String numExterior
    String entidadNacimiento
    String estadoCivil
    String regimen
    Genero genero
    String estudios
    String infonavit
    String cuentaBancaria
    Date fechaRegistro
    int noEmpleado
    String foto
    String password

    SqtEstado estado
    SqtPais pais
    SqtEstatus estatus
    SqtAcreedor acreedor
    SqtDeudor  deudor
    SqtCliente cliente
    SqtTelefono telefono
    SqtPassword histPassword

    static mapping = {
        genero enumType: 'ordinal'
    }

    static constraints = {
        username maxSize: 10
        foto maxSize: 50, nullable: true
        nombre maxSize: 50
        aPaterno maxSize: 50
        aMaterno maxSize: 50
        calle maxSize: 50, nullable: true
        colonia maxSize: 50, nullable: true
        municipio maxSize: 50, nullable: true
        cp maxSize: 5, nullable: true
        ciudad maxSize: 50, nullable: true
        email email: true, nullable: true
        numIntentos nullable: true
        fechaNacimiento nullable: true
        seguroSocial maxSize: 16, nullable: true
        curp maxSize: 20, nullable: true
        rfc maxSize: 13, nullable: true
        numInterior maxSize: 10, nullable: true
        numExterior maxSize: 20, nullable: true
        entidadNacimiento maxSize: 100, nullable: true
        estadoCivil maxSize: 50, nullable: true
        regimen maxSize: 50, nullable: true
        estudios maxSize: 50, nullable: true
        infonavit maxSize: 5, nullable: true
        cuentaBancaria maxSize: 30, nullable: true
        fechaRegistro nullable: true
        noEmpleado nullable: true
    }
}
