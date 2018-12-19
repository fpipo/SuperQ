package CENTRALSQ

class SqtVoucherDeclinado {
    String tarjeta
    String emisor
    Double monto
    String autcod
    Date fecha
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

    SqtVoucher voucher
    SqtTienda tienda
    SqtAfiliacion afiliacion
    SqtVenta venta
    SqtEstatus estatus
    SqtMovimiento movimiento
    SqtTransaccion transaccion

    static constraints = {
        tarjeta maxSize: 16,nullable: true
        emisor maxSize: 30,nullable: true
        venc maxSize: 5
        nombre maxSize: 30
        apellido maxSize: 30
        enviado nullable:true
        refeFinanciera maxSize: 8,nullable: true
        codResp maxSize: 2,nullable: true
        criptograma maxSize: 255,nullable: true
        ingreso maxSize: 50,nullable: true
        modoIngreso maxSize: 50,nullable: true
        respuesta maxSize: 2,nullable: true
        tipo maxSize: 1,nullable: true
        tvr maxSize: 100,nullable: true
        tsi maxSize: 100,nullable: true
        emvTags maxSize: 8000,nullable: true
        emvResult maxSize: 1,nullable: true
        estatus nullable: true
        enviado nullable: true
        estatus nullable: true
        transaccion nullable: true
    }
}

