package CENTRALSQ

class SqtGrupoTienda {

    String descripcion
    int base
    Double pctMargenUtilidad
    int principal
    int enviado
    SqtListaPrecios listaPrecios

    static constraints = {
        descripcion maxSize: 50, nullable: false
    }
}
