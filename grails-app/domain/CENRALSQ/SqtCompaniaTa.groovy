package CENRALSQ

class SqtCompaniaTa {
    String descripcion
    int enviado
    String ipRemota
    String socket
    String cel
    String tel
    String ftp
    String ftpPass
    String ftpUser
    String ftpDirectorio
    String pagWeb
    String refCarrie
    int cadena


    static constraints = {
        descripcion maxSize: 30, nullable: false
        ipRemota maxSize: 15, nullable: true
        socket maxSize: 5, nullable: true
        cel maxSize: 10, nullable: true
        tel maxSize: 20, nullable: true
        ftp maxSize: 15, nullable: true
        ftpPass maxSize: 30, nullable: true
        ftpUser maxSize: 30, nullable: true
        ftpDirectorio maxSize: 30, nullable: true
        pagWeb maxSize: 50, nullable: true
        refCarrie maxSize: 3, nullable: true
    }
}
