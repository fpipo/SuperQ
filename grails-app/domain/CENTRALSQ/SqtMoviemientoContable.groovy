package CENTRALSQ

class SqtMoviemientoContable {

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

    SqtGrupo grupo


    static constraints = {
        cuentaContable maxSize: 30
        idContabilizacion maxSize: 2
        idIva maxSize: 2
        texto maxSize: 50
        referencia maxSize: 18
        idContabilizacionInverso maxSize: 2
        tipo maxSize: 1
        enviado nullable:true
        tipoLinea maxSize: 20

    }
}
