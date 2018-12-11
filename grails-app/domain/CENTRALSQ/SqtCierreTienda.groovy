package CENTRALSQ

class SqtCierreTienda {
    Date diaOperacion
    Date fechamod
    int enviado

    SqtUsuario usuarioMod
    SqtTienda tienda

    static constraints = {
        enviado nuluable: true
    }
}
