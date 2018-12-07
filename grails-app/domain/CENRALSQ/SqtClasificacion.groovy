package CENRALSQ

class SqtClasificacion {
    String descripcion
    String cuentaContable
    int enviado
    SqtGrupo grupo
    SqtSegmentos Segmentos

    static constraints = {
        descripcion maxSize: 50, nullable: false
        cuentaContable maxSize: 30, nullable: false
    }
}
