package com.pangolinkeys.requests.contracts;

public interface ResponseHandler<T> {
    public void onComplete(T response);
}
