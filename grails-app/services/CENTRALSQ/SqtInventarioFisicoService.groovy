package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtInventarioFisico)
interface SqtInventarioFisicoService {

    SqtInventarioFisico get(Serializable id)

    List<SqtInventarioFisico> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtInventarioFisico save(SqtInventarioFisico sqtInventarioFisico)

}