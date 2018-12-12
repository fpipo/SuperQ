package CENTRALSQ

class SqtRemesas {


    String desTranType
    String folio
    String mensaje
    String operador
    String claveEnvio
    Date fecha
    Date hora
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
        importeEnviar  maxSize: 20
        comision maxSize: 20
        total maxSize: 20
        totalPagar maxSize: 20
        tc maxSize: 20
        enviado nullable:true
        mensajeTicket maxSize: 500
        caja maxSize: 3
        origen maxSize: 300
        tipoIdentificacion maxSize: 50
        numeroIdentificacion maxSize: 50

    }
}
