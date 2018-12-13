package CENTRALSQ

class SqtRecargaServicios {

    Double monto
    SqtServicio servicio
    SqtEstatus estatus
    int enviado


    static constraints = {
        enviado nullable:true

    }
}
