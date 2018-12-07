package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtDatosTiendaPM)
interface SqtDatosTiendaPMService {

    SqtDatosTiendaPM get(Serializable id)

    List<SqtDatosTiendaPM> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDatosTiendaPM save(SqtDatosTiendaPM sqtDatosTiendaPM)

}