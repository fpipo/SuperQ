package CENTRALSQ

class SqtVoucher {
    String id
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
    String transaccion
    String criptograma
    String idIngreso
    String modoIngreso
    int partida
    String tipo
    String tvr
    String tsi
    String emvTags
    String emvRsult
    String pRefer
    Double montoCash
    String modoCard
    String pinAmrican

    SqtTienda tienda
    SqtAfiliacion afiliacion
    SqtVenta referencia
    SqtEstatus estatus
    SqtMovimiento movimiento

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        tarjeta maxSize: 16,nullable: true
        emisor maxSize: 30,nullable: true
        autcod maxSize: 50
        hora maxSize: 12
        venc maxSize: 5
        nombre maxSize: 30, nullable: false
        apellido maxSize: 30, nullable: false
        refeFinanciera maxSize: 8,nullable: true
        codResp maxSize: 2,nullable: true
        criptograma maxSize: 255,nullable: true
        idIngreso maxSize: 50,nullable: true
        modoIngreso maxSize: 50,nullable: true
        partida nullable: true
        tipo maxSize: 1,nullable: true
        enviado nullable: true
        estatus nullable: true
        transaccion nullable: true
        partida nullable: true
        tipo nullable: true
        pinAmrican maxSize: 50, nullable: true
        modoCard maxSize: 30,nullable: true
        tvr maxSize: 100,nullable: true
        tsi maxSize: 100,nullable: true
        emvTags maxSize: 8000,nullable: true
        emvRsult maxSize: 1,nullable: true
        pRefer maxSize: 30, nullable: true
        montoCash nullable: true
    }
}
