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

    static constraints = {
        cliente nullable: true
    }
}

/* Solo para CentralSQ */
