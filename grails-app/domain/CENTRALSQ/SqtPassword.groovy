package CENTRALSQ

class SqtPassword {

    String password
    Date fechaMod
    SqtUsuario usuario

    static constraints = {
        password maxSize: 50, nullable: true
        fechaMod nullable:true


    }
}
