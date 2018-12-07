package CENTRALSQ

class SqtMovimiento {
    String descripcion
    String tipoMovimiento
    int orden
    String textoCabecera
    String referenciaCabecera
    String grupo
    int opcion
    String nombreSp
    String criterioOrigen
    String criterioDestino
    String archivoDatos
    String archivoControl
    String referenciaTabla
    String criterioTipo
    String movimientoInversa
    int consumible
    int enviado
    SqtAlmacen almacen
    SqtListaPrecios listaPrecios
    SqtClaseDocumento claseDocumento

    static constraints = {
        descripcion maxSize: 50, nullable: false
        tipoMovimiento maxSize: 2, nullable: false
        textoCabecera maxSize: 25
        referenciaCabecera maxSize: 16
        grupo maxSize: 3
        nombreSp maxSize: 50
        criterioOrigen maxSize: 50
        criterioDestino maxSize: 50
        archivoDatos maxSize: 30
        archivoControl maxSize: 30
        referenciaTabla maxSize: 30
        criterioTipo maxSize: 50
        movimientoInversa maxSize: 3
    }
}
