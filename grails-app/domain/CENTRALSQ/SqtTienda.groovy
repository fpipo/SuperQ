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
    String telefono
    SqtRuta ruta
    SqtGrupoTienda grupoTienda
    SqtEstatus estatus
    SqtSegmentos segmento
    SqtGrupoGlasgo grupoGlasgo

    static mapping = {
        id generator: 'uuid', name:'id'
    }

    static constraints = {
        descripcion maxSize: 80, nullable: false
        calle maxSize: 50, nullable: true
        colonia maxSize: 50, nullable: true
        municipio maxSize: 50, nullable: true
        cp maxSize: 5, nullable: true
        ciudad maxSize: 50, nullable: true
        estado nullable: true
        pais maxSize: 50, nullable: true
        telefono maxSize: 10, nullable: true
        tipo maxSize: 2, nullable: true
        centroCostos maxSize: 30, nullable: true
        fechaApertura nullable: true
        serie maxSize: 5, nullable:true
        cc maxSize: 3, nullable: true
        enviado nullable: true
        idServidor nullable: true
        grupoGlasgo nullable: true
        segmento nullable: true
        idGrupoTiendaExtra nullable: true
        telefono maxSize: 10, nullable: true
    }
}
