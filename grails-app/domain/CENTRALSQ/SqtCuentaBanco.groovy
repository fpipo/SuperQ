package CENTRALSQ

class SqtCuentaBanco {
    String numCuenta
    String tipoCuenta
    String terminal

    SqtBanco banco
    SqtTienda tienda
    SqtCaja caja

    static constraints = {
        numCuenta maxSize: 50
        tipoCuenta maxSize: 15,nullable: true
        terminal maxSize: 50, nullable: true
        tienda nullable: true
        caja nullable: true
    }
}
