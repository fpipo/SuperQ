package CENTRALSQ

import grails.gorm.services.Service

@Service(SqTKardexTa)
interface SqTKardexTaService {

    SqTKardexTa get(Serializable id)

    List<SqTKardexTa> list(Map args)

    Long count()

    void delete(Serializable id)

    SqTKardexTa save(SqTKardexTa sqTKardexTa)

}