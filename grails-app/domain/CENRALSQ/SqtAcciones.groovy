package CENRALSQ

class SqtAcciones {
    String accion

    static constraints = {
        accion maxSize: 20, nullable: true
    }
}
