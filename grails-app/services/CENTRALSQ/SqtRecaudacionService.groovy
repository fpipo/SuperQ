package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtRecaudacion)
interface SqtRecaudacionService {

    SqtRecaudacion get(Serializable id)

    List<SqtRecaudacion> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtRecaudacion save(SqtRecaudacion sqtRecaudacion)

}