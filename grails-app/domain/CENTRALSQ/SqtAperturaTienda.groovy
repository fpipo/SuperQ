package CENTRALSQ

class SqtAperturaTienda {
    Date diaOperacion
    String comentarios
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtUsuario usuarioMod
    SqtEstatus estatus

    static constraints = {
        comentarios maxSize: 250,nullable: true
        enviado nullable:true
    }
}
