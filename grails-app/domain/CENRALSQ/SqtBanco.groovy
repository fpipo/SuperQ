package CENRALSQ

class SqtBanco {
    String clave
    String descripcion
    String numCuenta

    static constraints = {
        clave maxSize: 3, nullable: false
        descripcion maxSize: 50, nullable: false
        numCuenta maxSize: 20, nullable: false
    }
}
