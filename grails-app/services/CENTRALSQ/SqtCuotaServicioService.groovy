package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtCuotaServicio)
interface SqtCuotaServicioService {

    SqtCuotaServicio get(Serializable id)

    List<SqtCuotaServicio> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtCuotaServicio save(SqtCuotaServicio sqtCuotaServicio)

}