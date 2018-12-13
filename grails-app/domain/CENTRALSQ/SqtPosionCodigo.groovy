package CENTRALSQ

class SqtPosionCodigo {
    String	tipo
    int	posicionInicio
    int	posicionFin
    int	digitos
    int	digitoInicio
    int	enviado

    SqtTipo idtipo
    SqtNsegmento nsegmento


    static constraints = {
        tipo maxSize: 3
        enviado nullable:true

    }
}
