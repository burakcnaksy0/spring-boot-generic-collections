package com.burakcanaksoy.layer1;

import java.util.*;
// entity-request-response
public interface BaseMapper<E, V, M> {
    E mapToEntity(V request);
    M mapToResponse(E entity);
    default List<M> mapToResponseList(List<E> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return List.of();
        }
        return entityList.stream()
                .map(this::mapToResponse)
                .toList();
    }
}
