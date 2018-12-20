package CENTRALSQ

class SqtProductosTa {
    SqtProducto producto
    SqtEstatus estatus
    SqtServicio servicio
    String sku
    int enviado
    int monto

    static constraints = {
        estatus nullable: true
        servicio nullable: true
        sku maxSize: 100, nullable: true
        monto nullable:true
    }
}
