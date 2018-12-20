package CENTRALSQ

class SqtPagoTipoVenta {
    int enviado

    SqtFormaPago formaPago
    SqtCuentaContable cuentaContable
    SqtMovimiento tipoVenta

    static constraints = {
        cuentaContable nullable:true
        enviado nullable:true
    }
}
