package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleParcial)
interface SqtDetalleParcialService {

    SqtDetalleParcial get(Serializable id)

    List<SqtDetalleParcial> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleParcial save(SqtDetalleParcial sqtDetalleParcial)

}