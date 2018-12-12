package CENTRALSQ

class SqtLogServicel {

    Date diaOperacion
    String telefono
    String monto
    String compania
    String mensaje
    String respuesta
    String tipo
    String codigoRespuesta
    String codAutorizacion
    String identificadorPOS
    Date fechaSolicitud
    Date fechaRespuestaServicel
    String saldoInicial
    String saldoFinal
    SqtUsuario usuarioMod
    int enviado

    SqtTienda tienda
    SqtTransaccion transaccion
    SqtEstatus estatus




    static constraints = {

        telefono maxSize: 20
        monto maxSize: 50
        compania maxSize: 50
        mensaje maxSize: 100
        respuesta maxSize: 2
        tipo maxSize: 2
        codigoRespuesta maxSize: 5
        codAutorizacion maxSize: 50
        identificadorPOS maxSize: 50
        saldoInicial maxSize: 50
        saldoFinal maxSize: 50
        enviado nullable:true

    }
}
