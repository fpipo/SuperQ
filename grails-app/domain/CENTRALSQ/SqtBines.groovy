package CENTRALSQ

class SqtBines {
    String producto
    String banco

    static constraints = {
        producto maxSize: 1
        banco maxSize: 50
    }
}
