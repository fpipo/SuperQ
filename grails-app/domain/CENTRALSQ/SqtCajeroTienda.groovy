package CENTRALSQ

class SqtCajeroTienda {
    Date fecha
    String comentarios
    Double cantidadInicial
    Date fechaMod
    int enviado
    int caja

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod, usuario

    static constraints = {
        comentarios maxSize: 250, nullable: true
        enviado nullable:true
        cantidadInicial nullable: true
    }
}
