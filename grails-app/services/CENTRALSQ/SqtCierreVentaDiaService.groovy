package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCierreVentaDia)
interface SqtCierreVentaDiaService {

    SqtCierreVentaDia get(Serializable id)

    List<SqtCierreVentaDia> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCierreVentaDia save(SqtCierreVentaDia sqtCierreVentaDia)

}