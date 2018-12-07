package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtFolioe)
interface SqtFolioeService {

    SqtFolioe get(Serializable id)

    List<SqtFolioe> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtFolioe save(SqtFolioe sqtFolioe)

}