package CENTRALSQ

class SqtCategoria {
    String descripcion
    int ordenB
    int  enviado

    static constraints = {
        descripcion maxSize: 50
        enviado nulluable: true
        ordenB nullable:true
    }
}
