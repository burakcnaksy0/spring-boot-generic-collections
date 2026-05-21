package com.burakcanaksoy.layer1.base.advanced.controller;

public interface CrudController<Request,Response,ID> extends ReadOnlyController<Response,ID> ,
                                                            WriteOnlyController<Request,Response,ID>
{

}
