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
        cantidad nullable: true
        cantidadReal nullable: true
        aplica nullable:true
        enviado nuluable: true
        sobrante nullable: true
    }
}
