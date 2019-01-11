package CENTRALSQ

class SqtCuentabancoTerminal {


    String numCuenta
    String tipoCuenta
    String terminal
    int caja
    int enviado


    SqtBanco banco
    SqtTienda tienda

    static constraints = {
        numCuenta maxSize: 50
        tipoCuenta maxSize: 15 ,nullable: true
        terminal maxSize: 10 , nullable: true
        enviado nullable:true
        tienda nullable: true
        caja nullable: true

    }
}
