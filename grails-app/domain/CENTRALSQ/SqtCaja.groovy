package CENTRALSQ

class SqtCaja {
    int caja
    Date diaOperacion
    String comentarios
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        enviado nullable: true
        estatus nullable: true
        comentarios maxSize: 1000, nullable: true
    }
}
