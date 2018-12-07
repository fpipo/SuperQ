package CENTRALSQ

import grails.gorm.services.Service

@Service(SQtNsegmentos)
interface SQtNsegmentosService {

    SQtNsegmentos get(Serializable id)

    List<SQtNsegmentos> list(Map args)

    Long count()

    void delete(Serializable id)

    SQtNsegmentos save(SQtNsegmentos SQtNsegmentos)

}