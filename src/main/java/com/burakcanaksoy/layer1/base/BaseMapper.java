package com.burakcanaksoy.layer1.base;

import java.util.*;
public interface BaseMapper<Request, Entity, Response> {
    Entity mapToEntity(Request request);
    Response mapToResponse(Entity entity);
    default List<Response> mapToResponseList(List<Entity> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return List.of();
        }
        return entityList.stream()
                .map(this::mapToResponse)
                .toList();
    }
}
