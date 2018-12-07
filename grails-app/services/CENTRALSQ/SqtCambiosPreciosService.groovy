package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCambiosPrecios)
interface SqtCambiosPreciosService {

    SqtCambiosPrecios get(Serializable id)

    List<SqtCambiosPrecios> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCambiosPrecios save(SqtCambiosPrecios sqtCambiosPrecios)

}