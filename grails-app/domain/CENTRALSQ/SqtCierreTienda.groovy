package CENTRALSQ

class SqtCierreTienda {
    Date diaOperacion
    Date fechaMod
    int enviado

    SqtUsuario usuarioMod
    SqtTienda tienda

    static constraints = {
        enviado nuluable: true
    }
}
