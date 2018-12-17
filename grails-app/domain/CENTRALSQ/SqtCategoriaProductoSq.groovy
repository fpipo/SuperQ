package CENTRALSQ

class SqtCategoriaProductoSq {
    SqtProducto producto
    SqtCategoria categoria
    SqtGrupo grupo
    SqtSubgrupo subgrupo
    int enviado
    SqtMarca marca
    static constraints = {
        grupo nullable: true
        subgrupo nullable: true
        enviado nullable:true
        marca nullable: true
    }
}
