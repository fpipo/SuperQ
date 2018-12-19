package CENTRALSQ

class SqtInventarioCategoria {
    Date fechamod
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    SqtUsuario usuarioMod

    static constraints = {
        usuarioMod nullable: true
        enviado nullable: true
    }
}
