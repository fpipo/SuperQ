package CENTRALSQ

class SqtVoucherDeclinado {
    String tarjeta
    String emisor
    Double monto
    String autcod
    Date fecha
    String hora
    String venc
    String nombre
    String apellido
    int enviado
    String refeFinanciera
    String codResp
    String criptograma
    String ingreso
    String modoIngreso
    String partida
    String respuesta
    String tipo
    String tvr
    String tsi
    String emvTags
    String emvResult

    SqtTienda tienda
    SqtAfiliacion afiliacion
    SqtEstatus estatus
    SqtMovimiento movimiento
    SqtTransaccion transaccion



    static constraints = {
        tarjeta maxSize: 16
        emisor maxSize: 30
        hora maxSize: 12
        venc maxSize: 5
        nombre maxSize: 30
        apellido maxSize: 30
        enviado nullable:true
        refeFinanciera maxSize: 8
        codResp maxSize: 2
        criptograma maxSize: 255
        ingreso maxSize: 50
        modoIngreso maxSize: 50
        respuesta maxSize: 2
        tipo maxSize: 1
        tvr maxSize: 100
        tsi maxSize: 100
        emvTags maxSize: 8000
        emvResult maxSize: 1


    }
}
