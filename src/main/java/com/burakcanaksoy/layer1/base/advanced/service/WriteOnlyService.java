package com.burakcanaksoy.layer1.base.advanced.service;

public interface WriteOnlyService<Request,Response,ID> {
    Response create(Request request);
    void delete(ID id);
}
