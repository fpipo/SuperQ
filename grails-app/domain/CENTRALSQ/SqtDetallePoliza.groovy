package CENTRALSQ

class SqtDetallePoliza {
    int partida
    String cuentaContable
    String contabilizacion
    Double importe
    String division
    String centroCostos
    int secuencia
    String textoCabecera
    String referenciaCabecera
    String textoDetalle
    String referenciaCabeceraOriginal
    int enviado
    SqtTienda tienda
    SqtMovimiento movimiento
    SqtImpuesto impuesto
    SqtCondicionPago condicionPago
    SqtSegmentos segmentos
    SqtGrupo grupo

    static belongsTo = [polizas: SqtPoliza]

    static constraints = {
        cuentaContable maxSize: 30, nullable: false
        contabilizacion maxSize: 2, nullable: false
        division maxSize: 4
        centroCostos maxSize: 30
        textoCabecera maxSize: 25
        referenciaCabecera maxSize: 16
        textoDetalle maxSize: 25
        referenciaCabeceraOriginal maxSize: 16
    }
}
