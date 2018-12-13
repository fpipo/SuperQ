package CENTRALSQ

class SqtPagoTipoVenta {
    String formaPago
    String tipoVenta
    String cuentaContable
    int enviado




    static constraints = {
        formaPago maxSize: 3
        tipoVenta maxSize: 3
        cuentaContable maxSize: 30
        enviado nullable:true
    }
}
