package com.application.practices.mvvmDemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.application.practices.mvvmDemo.model.DataResponse;
import com.application.practices.mvvmDemo.services.DisposableManager;
import com.application.practices.mvvmDemo.services.RetrofitClient;
import com.application.practices.mvvmDemo.services.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

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


    public Observable<List<String >> getAllValues(){

        PublishSubject<List<String>> subject = PublishSubject.create();

        List<String > list = new ArrayList<>();

        list.add("One");

        subject.onNext(list);

        return subject;
    }

}
