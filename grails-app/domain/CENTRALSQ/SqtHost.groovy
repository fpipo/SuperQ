package CENTRALSQ

class SqtHost {
    String ip
    String hostName

    static constraints = {
        ip maxSize: 15
        hostName maxSize: 15
    }
}
