package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtPreciosOferta)
interface SqtPreciosOfertaService {

    SqtPreciosOferta get(Serializable id)

    List<SqtPreciosOferta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtPreciosOferta save(SqtPreciosOferta sqtPreciosOferta)

}