package CENTRALSQ

class SqtAsignacion {
    Date fecha
    String comentarios
    Double cantidadInicial
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        comentarios maxSize: 250, nullable: true
        enviado nullable:true
        cantidadInicial nullable: true
    }
}
