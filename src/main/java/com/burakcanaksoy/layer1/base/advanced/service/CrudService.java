package com.burakcanaksoy.layer1.base.advanced.service;

public interface CrudService<Request, Response, ID>
        extends ReadOnlyService<Response, ID>, WriteOnlyService<Request, Response, ID> {
}
