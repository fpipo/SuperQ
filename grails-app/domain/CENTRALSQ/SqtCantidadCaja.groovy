package CENTRALSQ

class SqtCantidadCaja {
    Double cantidad
    String caja

    SqtTienda tienda
    SqtAsignacion asignacion
    SqtFormaPago formaPago

    static constraints = {
        caja maxSize: 2
    }
}

/* Solo para ISYPOS*/