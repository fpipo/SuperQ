package CENTRALSQ

class SqtBolsaPreventa {
    String tipoPedido
    Double importe
    Double importeSurtido
    Date fechaMod
    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        tipoPedido maxSize: 1
        importeSurtido nullable: true
    }
}
