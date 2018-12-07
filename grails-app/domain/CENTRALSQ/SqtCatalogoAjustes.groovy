package CENTRALSQ

class SqtCatalogoAjustes {
    String descripcion
    String tipoAjuste
    SqtAlmacen almacen
    int orden
    String referenciaAjuste
    SqtClaseDocumento claseDocumento
    int Consumible
    SqtEstatus estatus
    int enviado
    Date fechaMod

    static constraints = {
        descripcion maxSize: 50, nullable: false
        tipoAjuste maxSize: 2,nullable: false
        referenciaAjuste maxSize: 3
    }
}
