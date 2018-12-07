package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleIusa)
interface SqtDetalleIusaService {

    SqtDetalleIusa get(Serializable id)

    List<SqtDetalleIusa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleIusa save(SqtDetalleIusa sqtDetalleIusa)

}