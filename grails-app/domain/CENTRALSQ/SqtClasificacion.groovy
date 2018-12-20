package CENTRALSQ

class SqtClasificacion {
    String descripcion
    String cuentaContable
    int enviado

    SqtGrupo grupo
    SqtSegmentos segmento

    static constraints = {
        descripcion maxSize: 50
        cuentaContable maxSize: 30, nullable:true
        enviado nuluable: true
        grupo nullable: true
        segmento nullable: true
    }
}
