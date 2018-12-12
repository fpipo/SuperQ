package CENTRALSQ

class SqtCuentaBanco {
    String numcuenta
    String tipocuenta
    String terminal

    SqtBanco Banco
    SqtTienda tienda
    SqtCaja caja

    static constraints = {
        numcuenta maxSize: 50
        tipocuenta maxSize: 15,nullable: true
        terminal maxSize: 50, nullable: true
    }
}
