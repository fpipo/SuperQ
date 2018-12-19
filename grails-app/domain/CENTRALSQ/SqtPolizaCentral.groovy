package CENTRALSQ

class SqtPolizaCentral {
    Date fechaDocumento
    String sociedad
    Date fechaContabilizacion
    String pediodo
    String comentarios
    Date fechaMod

    SqtClaseDocumento claseDocumento
    SqtMovimiento movimiento
    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod
    SqtCliente cliente
    SqtMoneda moneda

    static constraints = {
        moneda nullable: true
        cliente nullable: true
    }
}

/* Solo para CentralSQ */
