package CENTRALSQ

class SqtCajeroTienda {

    Date fecha
    String comentarios
    Double cantidadInicial
    Date fechaMod
    int enviado
    String usuario
    String caja

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        caja maxSize: 2
        usuario maxSize: 2
        comentarios maxSize: 250, nullable: true
        enviado nullable:true
        cantidadInicial nullable: true
    }
}
