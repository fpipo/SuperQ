package CENTRALSQ

class SqtEmisoresRemesa {
    String nombre
    int envio
    int cobro
    String codProdPago
    String codProdEnvio

    SqtEstatus estatus

    static constraints = {
        nombre maxSize: 100
        envio nullable: true
        cobro nullable: true
        codProdPago maxSize: 30, nullable: true
        codProdEnvio maxSize: 30, nullable: true
    }
}
