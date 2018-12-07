package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCodigoRespuesta)
interface SqtCodigoRespuestaService {

    SqtCodigoRespuesta get(Serializable id)

    List<SqtCodigoRespuesta> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCodigoRespuesta save(SqtCodigoRespuesta sqtCodigoRespuesta)

}