package CENTRALSQ

class SqtBines {
    String producto
    String banco

    static constraints = {
        producto maxSize: 1, nullable: false
        banco maxSize: 50, nullable: false
    }
}
