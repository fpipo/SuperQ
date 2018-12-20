package CENTRALSQ

class SqtTienda {
    String id
    String descripcion
    String calle
    String colonia
    String municipio
    String cp
    String ciudad

    String tipo
    String centroCostos
    Date fechaApertura
    String serie
    SqtUsuario usuarioMod
    Date fechaMod
    int enviado
    String cc
    int idGrupoTiendaExtra

    int idServidor
    SqtZona zona
    SqtEstado estado
    SqtPais pais
    SqtTelefono telefono
    SqtRuta ruta
    SqtGrupoTienda grupoTienda
    SqtEstatus estatus
    SqtNsegmento nsegmentos
    SqtGrupoGlasgo grupoGlasgo



    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        descripcion maxSize: 80, nullable: false
        calle nullable: true
        colonia nullable: true
        municipio nullable: true
        cp nullable: true
        ciudad nullable: true
        estado nullable: true
        pais nullable: true
        telefono nullable: true
        tipo maxSize: 2, nullable: true
        centroCostos maxSize: 30, nullable: true
        fechaApertura nullable: true
        serie maxSize: 5, nullable:true
        cc maxSize: 3, nullable: true
        enviado nullable: true
        idServidor nullable: true
        grupoGlasgo nullable: true
        nsegmentos nullable: true
        idGrupoTiendaExtra nullable: true
    }
}
