package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtIdioma)
interface SqtIdiomaService {

    SqtIdioma get(Serializable id)

    List<SqtIdioma> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtIdioma save(SqtIdioma sqtIdioma)

}