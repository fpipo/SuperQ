package CENTRALSQ

class SqtLogServicel {
    Date diaOperacion
    String transaccion
    String telefono
    String monto
    String compania
    String mensaje
    String respuesta
    String tipo
    String codigoRespuesta
    String codAutorizacion
    Date fechaSolicitud
    Date fechaRespuestaServicel
    String saldoInicial
    String saldoFinal
    SqtUsuario usuarioMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus
    SqtVenta ventaenta

    static constraints = {
        diaOperacion nullable: true
        transaccion maxSize: 100, nullable:  true
        telefono maxSize: 20, nullable:  true
        monto maxSize: 50, nullable:  true
        compania maxSize: 50, nullable:  true
        mensaje maxSize: 100, nullable:  true
        respuesta maxSize: 2, nullable:  true
        tipo maxSize: 2, nullable:  true
        codigoRespuesta maxSize: 5, nullable:  true
        codAutorizacion maxSize: 50, nullable:  true
        identificadorPOS maxSize: 50, nullable:  true
        saldoInicial maxSize: 50, nullable:  true
        saldoFinal maxSize: 50, nullable:  true
        enviado nullable:true
        fechaSolicitud nullable:true
        fechaRespuestaServicel nullable:true
    }
}
