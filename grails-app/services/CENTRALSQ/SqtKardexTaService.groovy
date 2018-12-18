package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtKardexTa)
interface SqtKardexTaService {

    SqtKardexTa get(Serializable id)

    List<SqtKardexTa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtKardexTa save(SqtKardexTa sqtKardexTa)

}