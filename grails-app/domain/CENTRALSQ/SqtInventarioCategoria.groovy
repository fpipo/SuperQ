package CENTRALSQ

class SqtInventarioCategoria {
    Date fecha
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subGrupo
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable:true
    }
}
