package CENTRALSQ

class SqtDireccion {
    String calle
    String colonia
    String municipio
    String cp
    String ciudad
    SqtUsuario usuario
    SqtEstado estado
    SqtPais pais

    static constraints = {
        calle maxSize: 50, nullable: false
        colonia maxSize: 50, nullable: false
        municipio maxSize: 50, nullable: false
        cp maxSize: 5, nullable: false
        ciudad maxSize: 50, nullable: false
    }
}
