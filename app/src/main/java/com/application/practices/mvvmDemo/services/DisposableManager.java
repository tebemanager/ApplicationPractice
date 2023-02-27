package com.application.practices.mvvmDemo.services;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DisposableManager {
    private static CompositeDisposable compositeDisposable;

    /*Add disposals*/
    public static void add(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }
    public static void addAll(Disposable... subscribe){
        getCompositeDisposable().addAll(subscribe);
    }

    public static void dispose() {
        getCompositeDisposable().dispose();
    }

    /*ini the disposal*/
    private static CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }

    private DisposableManager() {}
}
