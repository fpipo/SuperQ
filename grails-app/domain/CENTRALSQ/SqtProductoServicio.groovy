package CENTRALSQ

class SqtProductoServicio {
    SqtProducto producto
    String tipo
    Double maximo
    Double minimo
    SqtEstatus estatus
    SqtServicio servicio
    SqtImpuesto impuesto
    int enviado

    static constraints = {
        tipo maxSize: 3 , nullable: true
        estatus nullable: true
        servicio nullable: true
        impuesto nullable: true
        maximo nullable: true
      minimo nullable: true
        enviado nullable: true
    }
}
