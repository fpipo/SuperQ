package CENTRALSQ

class SqtCodigoRespuesta {
    String descripcion

    static constraints = {
        descripcion maxSize: 50, nullable: false
    }
}
