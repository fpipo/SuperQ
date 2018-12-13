package CENTRALSQ

class SqtInventarioGeneral {
    String descripcion
    Date fecha
    Date fechaMod
    int enviado

    SqtUsuario usuarioMod
    SqtTienda tienda
    SqtEstatus estatus

    static hasMany = [general:SqtInventario]

    static constraints = {
        descripcion maxSize: 500, nullable: true
        enviado nullable:true
    }
}
