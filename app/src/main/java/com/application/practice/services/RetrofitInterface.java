package com.application.practice.services;


/*
 * Created by Charles Raj I on 2022.
 *  @author Charles Raj I
 */

import com.application.practice.model.DataResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("api/otp-mgmt/health-check")
    Observable<DataResponse> getDatas();

}
