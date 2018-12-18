package CENTRALSQ

class SqtEmisoresComision {
    String nombre
    Double comision
    Double comisionC

    static constraints = {
        nombre maxSize: 100
        comision nullable: true
        comisionC nullable: true
    }
}
