package CENRALSQ

class SqtCajaTienda {
    SqtTienda tienda
    String caja
    static constraints = {
        caja maxSize: 2, nullable: false
    }
}
