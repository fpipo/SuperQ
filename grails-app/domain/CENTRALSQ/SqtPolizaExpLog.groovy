package CENTRALSQ

class SqtPolizaExpLog {

    String tipoPoliza
    int error
    String descripcion
    String usuarioMod
    Date fechaMod

    SqtPoliza poliza
    SqtTienda tienda
    SqtEstatus estatus

    static constraints = {
        tipoPoliza maxSize: 3
        descripcion maxSize: 255
        usuarioMod maxSize: 30
    }
}
