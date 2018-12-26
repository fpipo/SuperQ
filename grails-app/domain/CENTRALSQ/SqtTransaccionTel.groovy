package CENTRALSQ

class SqtTransaccionTel {
    Date diaOperacion

    SqtPedido pedido

    static constraints = {
        pedido nullable: true
        diaOperacion notEqual: true
    }
}
