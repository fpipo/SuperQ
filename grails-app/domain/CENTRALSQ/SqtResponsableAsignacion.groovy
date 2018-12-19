package CENTRALSQ

class SqtResponsableAsignacion {
    SqtTienda tienda
    SqtUsuario usuario
    Date fechaAplica
    SqtEstatus  estatus
    Date fechaMod
    String usuarioMod
    int enviado

    static constraints = {
        estatus nullable: true
        fechaMod nullable: true
        usuarioMod nullable: true
        enviado nullable:true
    }
}
