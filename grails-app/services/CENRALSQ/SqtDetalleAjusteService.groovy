package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleAjuste)
interface SqtDetalleAjusteService {

    SqtDetalleAjuste get(Serializable id)

    List<SqtDetalleAjuste> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleAjuste save(SqtDetalleAjuste sqtDetalleAjuste)

}