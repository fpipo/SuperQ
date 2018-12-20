package CENTRALSQ

class SqtCierreTienda {
    Date diaOperacion
    Date fechaMod
    int enviado

    SqtUsuario usuarioMod
    SqtTienda tienda

    static constraints = {
        fechaMod nullable: true
        usuarioMod nullable: true
        enviado nuluable: true
    }
}
