package CENTRALSQ

class SqtCuentabancoTerminal {


    String numCuenta
    String tipoCuenta
    String terminal
    String caja
    int enviado


    SqtBanco banco
    SqtTienda tienda

    static constraints = {
        numCuenta maxSize: 50
        tipoCuenta maxSize: 15
        terminal maxSize: 10
        enviado nullable:true
    }
}
