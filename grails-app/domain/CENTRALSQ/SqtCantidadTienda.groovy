package CENTRALSQ

class SqtCantidadTienda {
    Date diaOperacion
    Double cantidad
    Double cantidadReal
    int aplica
    int enviado
    Double sobrante

    SqtTienda tienda
    SqtFormaPago formaPago

    static constraints = {
        enviado nuluable: true
    }
}

/* Solo para ISYPOS*/