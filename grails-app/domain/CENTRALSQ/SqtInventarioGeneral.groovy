package CENTRALSQ

class SqtInventarioGeneral {
    String descripcion
    Date fecha
    Date fechaMod
    String usuarioMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus

    static hasMany = [general:SqtInventario]

    static constraints = {
        descripcion maxSize: 500, nullable: true
        usuarioMod maxSize: 15
        enviado nullable:true
    }
}
