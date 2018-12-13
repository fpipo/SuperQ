package CENTRALSQ

class SqtSubgrupo {
    String descripcion
    int aplicaFs
    int enviado
    Double pctCompra

    SqtGrupo grupo


    static constraints = {

        descripcion maxSize: 50
        enviado nullable:true
    }
}
