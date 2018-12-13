package CENTRALSQ

class SqtInventarioCartegoria {

    Date fechamod
    String usuarioMod
    int enviado

    SqtInventario inventario
    SqtTienda tienda
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo

    static constraints = {
        usuarioMod maxSize: 15
        enviado nullable:true

    }
}

