package CENTRALSQ

class SqtProductoServicio {
    String tipo
    Double maximo
    Double minimo
    SqtEstatus estatus
    SqtServicio servicio
    SqtImpuesto impuesto

    static constraints = {
        tipo maxSize: 3
    }
}
