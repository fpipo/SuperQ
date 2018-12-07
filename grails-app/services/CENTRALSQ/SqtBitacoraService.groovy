package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtBitacora)
interface SqtBitacoraService {

    SqtBitacora get(Serializable id)

    List<SqtBitacora> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtBitacora save(SqtBitacora sqtBitacora)

}