package CENTRALSQ

class SqtMovimientoContable {
    String cuentaContable
    String idContabilizacion
    int secuencia
    String idIva
    String texto
    String referencia
    int ordenEnvio
    String idContabilizacionInverso
    String tipo
    int enviado
    String tipoLinea

    SqtMovimiento movimiento
    SqtGrupo grupo
    SqtNsegmento nsgementos

    static constraints = {
        cuentaContable maxSize: 30
        idContabilizacion maxSize: 2
        idIva maxSize: 2 , nullable: true
        texto maxSize: 50 , nullable: true
        referencia maxSize: 18, nullable: true
        ordenEnvio  nullable: true
        idContabilizacionInverso maxSize: 2, nullable: true
        tipo maxSize: 1, nullable: true
        enviado nullable:true
        tipoLinea maxSize: 20, nullable: true
        nsgementos  nullable: true

    }
}
