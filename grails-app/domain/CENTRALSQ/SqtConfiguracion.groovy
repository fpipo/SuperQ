package CENTRALSQ

class SqtConfiguracion {
    String	descripcion
    String	valor
    Date	fechaMod
    int	enviado

    SqtUsuario usuarioMod

    static constraints = {
        descripcion maxSize: 50
        valor maxSize: 250
        enviado nulluable: true
    }
}
