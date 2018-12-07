package CENTRALSQ

class SqtAperturaTienda {
    Date diaOperacion
    String comentarios
    Date fechaMod
    int enviado
    SqtUsuario usuarioMod
    SqtEstatus estatus

    static constraints = {
        comentarios maxSize: 250
    }
}
