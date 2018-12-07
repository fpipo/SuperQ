package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtSegmentos)
interface SqtSegmentosService {

    SqtSegmentos get(Serializable id)

    List<SqtSegmentos> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtSegmentos save(SqtSegmentos sqtSegmentos)

}