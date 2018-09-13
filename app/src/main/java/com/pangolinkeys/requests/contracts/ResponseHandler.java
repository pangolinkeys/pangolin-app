package com.pangolinkeys.requests.contracts;

public interface ResponseHandler<T> {
    void onComplete(T response);
}
