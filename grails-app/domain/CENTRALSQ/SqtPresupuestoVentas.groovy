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
        idtienda nullable:true
        tienda nullable: true
        anio nullable: true
        mes nullable: true
        ventaproy nullable: true
        tktPromProy nullable: true
        trnProy nullable: true
        tienda maxSize: 100

    }
}
