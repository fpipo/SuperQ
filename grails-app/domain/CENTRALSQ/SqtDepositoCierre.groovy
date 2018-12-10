package CENTRALSQ

class SqtDepositoCierre {
    Date fecha
    Double monto
    String numCuenta
    SqtBanco banco
    SqtTienda tienda
    static constraints = {
        numCuenta maxSize: 50
    }
}
