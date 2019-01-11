package CENTRALSQ

class SqtRemesas {
    String desTranType
    String folio
    String mensaje
    String operador
    String claveEnvio
    Date fecha
    String remitente
    String beneficiario
    String emisor
    String autorizacion
    String importeEnviar
    String comision
    String total
    String totalPagar
    String tc
    int enviado
    String mensajeTicket
    String caja
    String origen
    String tipoIdentificacion
    String numeroIdentificacion
    Date diaOperacion

    SqtTienda tienda
    SqtTransaccion tranType

    static constraints = {
        folio maxSize: 50
        mensaje maxSize: 1000
        operador maxSize: 50
        claveEnvio maxSize: 50
        remitente maxSize: 500
        beneficiario maxSize: 50
        emisor maxSize: 200
        autorizacion maxSize: 50
        importeEnviar  maxSize: 20, nullable: true
        comision maxSize: 20, nullable: true
        total maxSize: 20, nullable: true
        totalPagar maxSize: 20, nullable: true
        tc maxSize: 20, nullable: true
        enviado nullable:true
        mensajeTicket maxSize: 500, nullable: true
        caja maxSize: 3, nullable: true
        origen maxSize: 300, nullable: true
        tipoIdentificacion maxSize: 50, nullable: true
        numeroIdentificacion maxSize: 50,nullable: true
        diaOperacion nullable: true
        asignacion nullable: true
    }
}
