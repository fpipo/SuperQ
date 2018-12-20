package CENTRALSQ

class SqtBines {
    String cuenta
    String producto
    String banco

    static constraints = {
        cuenta maxSize: 6
        producto maxSize: 1
        banco maxSize: 50, nullable: true
    }
}
