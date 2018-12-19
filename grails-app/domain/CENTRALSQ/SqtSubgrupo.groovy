package CENTRALSQ

class SqtSubgrupo {
    String descripcion
    int aplicaFs
    int enviado
    Double pctCompra

    SqtGrupo grupo


    static constraints = {
        aplicaFs nullable: true
        pctCompra nullable: true
        descripcion maxSize: 50
        enviado nullable:true
    }
}
