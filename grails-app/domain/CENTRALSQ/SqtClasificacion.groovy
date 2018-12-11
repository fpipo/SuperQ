package CENTRALSQ

class SqtClasificacion {
    String descripcion
    String cuentaContable
    int enviado

    SqtGrupo grupo
    SqtSegmentos segmento

    static constraints = {
        descripcion maxSize: 50
        cuentaContable maxSize: 30
        enviado nuluable: true
    }
}
