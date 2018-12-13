package CENTRALSQ

class SqtPresupuestoVentas {

    SqtTienda idtienda
    String tienda
    int anio
    int mes
    Double ventaproy
    Double tktPromProy
    Double trnProy

    static constraints = {
        tienda maxSize: 100
    }
}
