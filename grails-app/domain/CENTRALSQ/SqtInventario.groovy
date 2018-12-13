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
    String usuarioMod
    int enviado

    SqtTienda tienda
    SqtUsuario usuario
    SqtEstatus estatus
    SqtFactura factura
    SqtPoliza poliza

    static belongsTo = [general:SqtInventarioGeneral]

    static constraints = {
        descripcion maxSize: 250,nullable: true
        toma maxSize: 2, nullable: true
        horaFin maxSize: 10, nullable: true
        horaInicio maxSize: 10, nullable: true
        comentarios maxSize: 3000, nullable: true
        enviado nullable:true
    }
}
