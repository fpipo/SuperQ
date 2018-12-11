package CENTRALSQ

class SqtCajaTienda {
    String caja

    SqtTienda tienda

    static constraints = {
        caja maxSize: 2, nullable: false
    }
}
