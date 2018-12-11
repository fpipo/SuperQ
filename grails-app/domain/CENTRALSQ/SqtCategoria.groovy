package CENTRALSQ

class SqtCategoria {
    String descripcion
    int  enviado

    static constraints = {
        descripcion maxSize: 50
        enviado nuluable: true
    }
}
