package CENTRALSQ

class SqtInventarioGeneral {
    String descripcion
    Date fecha
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static hasMany = [general:SqtInventario]

    static constraints = {
        descripcion maxSize: 500, nullable: true
        enviado nullable:true
        fechaMod nullable:true
        estatus nullable:true
    }
}
