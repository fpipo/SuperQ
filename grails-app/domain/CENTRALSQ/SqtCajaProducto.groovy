package CENTRALSQ

class SqtCajaProducto {
    int contenido
    int principal
    int enviado

    SqtProducto producto
    SqtUnidadMedida unidadMedida

    static constraints = {
        contenido nullable:true
        principal nullable:true
        unidadMedida nullable: true
        enviado nullable: true
    }
}
