package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtBascula)
interface SqtBasculaService {

    SqtBascula get(Serializable id)

    List<SqtBascula> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtBascula save(SqtBascula sqtBascula)

}