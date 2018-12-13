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
        calle maxSize: 50
        colonia maxSize: 50
        municipio maxSize: 50
        cp maxSize: 5
        ciudad maxSize: 50
    }
}
