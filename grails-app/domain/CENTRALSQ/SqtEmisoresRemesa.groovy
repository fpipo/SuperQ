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
        codProdPago maxSize: 30, nullable: true
        codProdEnvio maxSize: 30, nullable: true
    }
}
