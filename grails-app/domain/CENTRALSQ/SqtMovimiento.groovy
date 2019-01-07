package CENTRALSQ

class SqtMovimiento {
    String clave
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
    String movimientoReferencia
    int consumible
    int enviado

    SqtAlmacen almacen
    SqtListaPrecios listaPrecios
    SqtClaseDocumento claseDocumento

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50, nullable: false
        tipoMovimiento maxSize: 2, nullable: false
        textoCabecera maxSize: 25
        referenciaCabecera maxSize: 16, nullable: true
        grupo maxSize: 3, nullable: true
        nombreSp maxSize: 50, nullable: true
        criterioOrigen maxSize: 50, nullable: true
        criterioDestino maxSize: 50, nullable: true
        archivoDatos maxSize: 30, nullable: true
        archivoControl maxSize: 30, nullable: true
        referenciaTabla maxSize: 30, nullable: true
        criterioTipo maxSize: 50, nullable: true
        movimientoInversa maxSize: 3, nullable: true
        consumible nullable: true
        orden nullable: true
        movimientoReferencia nullable: true
        textoCabecera  nullable: true
        opcion  nullable: true
        listaPrecios nullable: true
        claseDocumento maxSize: 2 , nullable: true
    }
}
