package CENTRALSQ

class SqtClasificacion {
    String descripcion
    String cuentaContable
    int enviado
    SqtGrupo grupo
    SqtSegmentos segmentos

    static constraints = {
        descripcion maxSize: 50, nullable: false
        cuentaContable maxSize: 30, nullable: false
    }
}
