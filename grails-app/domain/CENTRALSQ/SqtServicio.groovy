package CENTRALSQ

class SqtServicio {
    String descripcionCorta
    int digitos
    Double montoFijo
    int contabiliza
    int montoEditable
    int fechaEditable
    Double montoComision
    int diaVencimiento
    int diaFinComision
    int vigencia
    int porPosicion
    String separador
    String tipoArchivo
    int idAdeudor
    Double comisionServicio
    int enviado
    String descripcionTicket
    Double comisionC

    SqtEstatus estatus
    SqtAcreedor acreedor
    SqtProducto producto
    SqtProveedor proveedor
    SqtCliente cliente

    /*SqtAdeudor  no esta esta tabla
    * */

    static constraints = {
        montoFijo nullable: true
        contabiliza nullable: true
        montoEditable nullable: true
        diaVencimiento nullable: true
        diaFinComision nullable: true
        vigencia nullable: true
        porPosicion nullable: true
        descripcionCorta maxSize: 30
        separador maxSize: 1, nullable: true
        acreedor nullable: true
        idAdeudor nullable: true
        comisionServicio nullable: true
        tipoArchivo maxSize: 10
        enviado nullable:true
        descripcionTicket nullable: true
        producto nullable: true
        comisionC nullable: true
        proveedor nullable: true
        cliente nullable: true
    }
}
