package CENTRALSQ

class SqtProductosTa {
    SqtProducto producto
    SqtEstatus estatus
    String idServicio
    String sku
    int enviado
    int monto

    static constraints = {
        estatus nullable: true
        idServicio nullable: true
        sku maxSize: 100, nullable: true
        monto nullable:true
    }
}
