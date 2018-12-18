package CENTRALSQ

class SqtConfiguracionFtp {
    SqtTienda tienda
    String serie
    String ftpServer
    String ftpUser
    String ftpPwd
    String ftpPath
    String ftpPathB
    String ftpFileName

    static constraints = {

        serie  maxSize: 3 , nullable: true
        ftpServer maxSize: 128 , nullable: true
        ftpUser maxSize: 128 , nullable: true
        ftpPwd maxSize: 128 , nullable: true
        ftpPath maxSize: 128 , nullable: true
        ftpPathB maxSize: 128 , nullable: true
        ftpFileName maxSize: 128 , nullable: true

    }
}
