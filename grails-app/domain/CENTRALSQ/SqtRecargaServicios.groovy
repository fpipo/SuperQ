package CENTRALSQ

class SqtRecargaServicios {

    Double monto
    SqtServicio servicio
    SqtEstatus estatus
    int enviado


    static constraints = {
        servicio nullable: true
        monto nullable: true
        estatus nullable: true
        enviado nullable:true

    }
}
