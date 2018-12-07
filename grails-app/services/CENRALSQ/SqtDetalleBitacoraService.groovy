package CENRALSQ

import grails.gorm.services.Service

@Service(SqtDetalleBitacora)
interface SqtDetalleBitacoraService {

    SqtDetalleBitacora get(Serializable id)

    List<SqtDetalleBitacora> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtDetalleBitacora save(SqtDetalleBitacora sqtDetalleBitacora)

}