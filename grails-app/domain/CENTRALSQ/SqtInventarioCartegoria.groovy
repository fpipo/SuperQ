package CENTRALSQ

class SqtInventarioCartegoria {

    Date fechamod
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable:true

    }
}
