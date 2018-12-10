package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtNsegmento)
interface SqtNsegmentoService {

    SqtNsegmento get(Serializable id)

    List<SqtNsegmento> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtNsegmento save(SqtNsegmento sqtNsegmento)

}