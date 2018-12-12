package CENTRALSQ

class SqtInventario {

    String descripcion
    Date fecha
    int aplica
    String toma
    String horaInicio
    String horaFin
    String comentarios
    int opcion
    Date fechaMod
    String UsuarioMod

    int enviado

    SqtTienda tienda
    SqtUsuario usuario
    SqtEstatus estatus
    SqtFactura factura
    SqtPoliza poliza



    static constraints = {
        horaFin maxSize: 10
        horaInicio maxSize: 10
        comentarios maxSize: 3000
        enviado nullable:true

    }
}
