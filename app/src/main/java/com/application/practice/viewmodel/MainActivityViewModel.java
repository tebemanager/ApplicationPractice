package com.application.practice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.application.practice.model.DataResponse;
import com.application.practice.services.DisposableManager;
import com.application.practice.services.RetrofitClient;
import com.application.practice.services.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 30/04/22.
 *
 * @author Charles Raj I
 */
public class MainActivityViewModel extends AndroidViewModel {

    MutableLiveData<DataResponse> dataResponseMutableLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        dataResponseMutableLiveData = new MutableLiveData<>();
        getAllDatas();
    }
    /*Use this method to get the live data*/
    public MutableLiveData<DataResponse> getUserMutableLiveData(){
        return dataResponseMutableLiveData;
    }

    /*Get data from api and send to the mutable live data*/
    public void getAllDatas(){
        RetrofitInterface service = RetrofitClient.getClient();

        DisposableManager.add(service.getDatas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataResponse -> {
                    dataResponseMutableLiveData.setValue(dataResponse);
                }));
    }

}
