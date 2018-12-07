package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioGeneral)
interface SqtInventarioGeneralService {

    SqtInventarioGeneral get(Serializable id)

    List<SqtInventarioGeneral> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioGeneral save(SqtInventarioGeneral sqtInventarioGeneral)

}