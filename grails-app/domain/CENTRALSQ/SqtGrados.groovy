package CENTRALSQ

class SqtGrados {
    Double grados

    SqtProducto producto

    static constraints = {
        producto nullable: true
        grados nullable:true
    }
}
