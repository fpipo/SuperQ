package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtArchivo)
interface SqtArchivoService {

    SqtArchivo get(Serializable id)

    List<SqtArchivo> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtArchivo save(SqtArchivo sqtArchivo)

}