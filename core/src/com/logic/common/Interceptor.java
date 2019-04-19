package com.logic.common;

import com.logic.logging.Context;

public interface Interceptor {

    void preRequest(Context c);
    void postRequest(Context c);

}
