package CENTRALSQ

class SqtInventarioCategoria {
    Date fechaMod
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable: true
    }
}
