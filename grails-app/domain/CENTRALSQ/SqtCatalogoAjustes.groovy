package CENTRALSQ

class SqtCatalogoAjustes {
    String descripcion
    String tipoAjuste
    int orden
    String referenciaAjuste
    int consumible

    int enviado
    Date fechaMod

    SqtAlmacen almacen
    SqtClaseDocumento claseDocumento
    SqtEstatus estatus

    static constraints = {
        descripcion maxSize: 50
        orden nullable:true
        referenciaAjuste maxSize: 3 , nullable: true
        tipoAjuste maxSize: 2
        referenciaAjuste maxSize: 3, nullable: true
        enviado nullable: true
        claseDocumento nullable: true
        fechaMod nullable: true
    }
}
