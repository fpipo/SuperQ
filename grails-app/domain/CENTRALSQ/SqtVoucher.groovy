package CENTRALSQ

class SqtVoucher {
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
    String idIngreso
    String modoIngreso
    int partida
    String tipo
    Double montoCash
    SqtTienda tienda
    SqtAfiliacion afiliacion
    SqtVenta referencia
    SqtEstatus estatus
    SqtMovimiento movimiento

    static constraints = {
        tarjeta maxSize: 16
        emisor maxSize: 30
        autcod maxSize: 50, nullable: false
        hora maxSize: 12, nullable: false
        venc maxSize: 5, nullable: false
        nombre maxSize: 30, nullable: false
        apellido maxSize: 30, nullable: false
        refeFinanciera maxSize: 8
        codResp maxSize: 2
        criptograma maxSize: 255
        idIngreso maxSize: 50
        modoIngreso maxSize: 50
        tipo maxSize: 1
    }
}
