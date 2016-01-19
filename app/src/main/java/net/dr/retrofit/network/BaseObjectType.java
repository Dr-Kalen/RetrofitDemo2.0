package net.dr.retrofit.network;

/**
 * Created by kalen on 15/8/18.
 */
public class BaseObjectType<T> extends BaseHeader {

    public T data;

    public  T getObject(){
        return data;
    }

}
