package CENTRALSQ

import grails.gorm.services.Service

@Service(SqtGrupoUsuario)
interface SqtGrupoUsuarioService {

    SqtGrupoUsuario get(Serializable id)

    List<SqtGrupoUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    SqtGrupoUsuario save(SqtGrupoUsuario sqtGrupoUsuario)

}