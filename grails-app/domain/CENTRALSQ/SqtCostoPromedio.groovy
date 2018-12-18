package CENTRALSQ

class SqtCostoPromedio {
    SqtProducto producto
    Date fecha
    Double costoPromedio
    Double ivaCostoPromedio
    Double saldo
    Double unidades
    int enviado

    static constraints = {
        costoPromedio nullable: true
        ivaCostoPromedio nullable: true
        saldo nullable: true
        unidades nullable: true
        enviado nullable:true
    }
}
