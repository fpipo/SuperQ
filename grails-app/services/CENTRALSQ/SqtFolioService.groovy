package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFolio)
interface SqtFolioService {

    SqtFolio get(Serializable id)

    List<SqtFolio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFolio save(SqtFolio sqtFolio)

}