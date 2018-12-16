package CENTRALSQ

class SqtCaja {
    String caja
    Date diaOperacion
    String comentarios
    Date fechaMod
    int enviado

    SqtTienda tienda
    SqtEstatus estatus
    SqtUsuario usuarioMod

    static constraints = {
        caja maxSize: 2
        enviado nulable: true
        comentarios maxSize: 1000, nulable: true
    }
}
