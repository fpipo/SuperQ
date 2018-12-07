package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCompaniaTa)
interface SqtCompaniaTaService {

    SqtCompaniaTa get(Serializable id)

    List<SqtCompaniaTa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCompaniaTa save(SqtCompaniaTa sqtCompaniaTa)

}