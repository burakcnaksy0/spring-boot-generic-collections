package com.burakcanaksoy.layer1.base;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public abstract class BaseService<Request, Entity, Response, ID> {

    protected final JpaRepository<Entity, ID> repository;
    protected final BaseMapper<Request, Entity, Response> mapper;
    protected final Class<Entity> entityClass;

    protected BaseService(
            JpaRepository<Entity, ID> repository,
            BaseMapper<Request, Entity, Response> mapper,
            Class<Entity> entityClass
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.entityClass = entityClass;
    }

    public Response getById(ID id){
        Entity entity = repository.findById(id).orElseThrow(() ->
                new RuntimeException(entityClass.getSimpleName() + " bulunamadı: "+ id));
        return mapper.mapToResponse(entity);
    }

    public Response create(Request request){
        Entity entity = mapper.mapToEntity(request);
        repository.save(entity);
        return mapper.mapToResponse(entity);
    }

    public List<Response> getAll(){
        List<Entity> entityList = repository.findAll();
        return mapper.mapToResponseList(entityList);
    }

    public void delete(ID id){
        Entity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(entityClass.getSimpleName() + " bulunamadı: "+ id));
        repository.delete(entity);
    }
}