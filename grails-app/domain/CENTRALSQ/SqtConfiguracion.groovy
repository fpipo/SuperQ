package CENTRALSQ

class SqtConfiguracion {
    String clave
    String	descripcion
    String	valor
    Date	fechaMod
    int	enviado

    SqtUsuario usuarioMod

    static constraints = {
        clave maxSize: 5
        descripcion maxSize: 50
        valor maxSize: 250
        enviado nulluable: true
    }
}
