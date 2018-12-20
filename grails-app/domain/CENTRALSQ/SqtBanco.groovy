package CENTRALSQ

class SqtBanco {
    String clave
    String descripcion
    String numCuenta

    static constraints = {
        clave maxSize: 3
        descripcion maxSize: 50
        numCuenta maxSize: 20
    }
}
