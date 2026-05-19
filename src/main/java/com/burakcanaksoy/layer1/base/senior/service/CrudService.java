package com.burakcanaksoy.layer1.base.senior.service;

public interface CrudService<Request, Response, ID>
        extends ReadOnlyService<Response, ID>, WriteOnlyService<Request, Response, ID> {
}
