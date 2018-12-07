package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFactura)
interface SqtFacturaService {

    SqtFactura get(Serializable id)

    List<SqtFactura> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFactura save(SqtFactura sqtFactura)

}