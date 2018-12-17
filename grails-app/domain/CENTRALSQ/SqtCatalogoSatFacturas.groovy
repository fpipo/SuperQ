package CENTRALSQ

class SqtCatalogoSatFacturas {
    String claveProdSer
    String descripcion
    int enviado
    SqtEstatus estatus
    SqtGrupo grupo
    static constraints = {
        claveProdSer maxSize: 20
        descripcion maxSize: 200, nullable: true
        enviado nullable:true
        estatus nullable: true
        grupo nullable: true
    }
}
