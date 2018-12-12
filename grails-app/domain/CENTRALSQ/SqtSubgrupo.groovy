package CENTRALSQ

class SqtSubgrupo {
    String descripcion
    int aplicaFs
    int enviado
    Double pctCompra

    SqtGrupo grupo


    static constraints = {

        enviado nullable:true
    }
}
