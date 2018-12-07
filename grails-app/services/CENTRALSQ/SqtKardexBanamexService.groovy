package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtKardexBanamex)
interface SqtKardexBanamexService {

    SqtKardexBanamex get(Serializable id)

    List<SqtKardexBanamex> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtKardexBanamex save(SqtKardexBanamex sqtKardexBanamex)

}