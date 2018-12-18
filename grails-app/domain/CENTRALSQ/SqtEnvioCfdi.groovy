package CENTRALSQ

class SqtEnvioCfdi {
    String estatus
    int enviado

    SqtVenta venta
    SqtTienda tienda

    static constraints = {
        estatus maxSize: 3
        enviado nullable:true
    }
}

/* Solo para ISYPOS */