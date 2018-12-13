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
    Double comisionServicio
    int enviado
    String descripcionTicket
    Double comisionC

    SqtEstatus estatus
    SqtAcreedor acreedor
    SqtProducto productoref
    SqtProveedor proveedor
    SqtCliente cliente

    /*SqtAdeudor  no esta esta tabla
    * */

    static constraints = {
        descripcionCorta maxSize: 30
        separador maxSize: 1
        tipoArchivo maxSize: 10
        enviado nullable:true

    }
}
