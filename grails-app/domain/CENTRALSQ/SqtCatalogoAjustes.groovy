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
        tipoAjuste maxSize: 2
        referenciaAjuste maxSize: 3, nullable: true
        enviado nullable: true
    }
}
