package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtKardex)
interface SqtKardexService {

    SqtKardex get(Serializable id)

    List<SqtKardex> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtKardex save(SqtKardex sqtKardex)

}