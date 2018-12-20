package CENTRALSQ

class SqtSubgrupo {
    String descripcion
    int enviado
    Double pctCompra

    SqtGrupo grupo

    static constraints = {
        pctCompra nullable: true
        descripcion maxSize: 50
        enviado nullable:true
    }
}
