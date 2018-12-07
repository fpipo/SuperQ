package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCatalgoPanHorneado)
interface SqtCatalgoPanHorneadoService {

    SqtCatalgoPanHorneado get(Serializable id)

    List<SqtCatalgoPanHorneado> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCatalgoPanHorneado save(SqtCatalgoPanHorneado sqtCatalgoPanHorneado)

}