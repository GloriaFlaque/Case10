package com.gloria.case10;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JobsViewModel extends ViewModel {

    private JobsRepository jobsRepository = JobsRepository.getInstance();
    public MutableLiveData<List<StatsData>> dataFornite = new MutableLiveData<>();
    public List<StatsData> dataList = new ArrayList<>();


    public void getData(String platform, String epic_nickname){

        jobsRepository.getInfoFornite(platform,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Fortnite>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fortnite forniteObject) {
                        //liveData.postValue(forniteObjects);
                        if(forniteObject!=null) {
                            dataList.clear();
                            Data data = forniteObject.getStats().getData();
                            dataList.add(data.getScore());
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKills());
                            dataFornite.postValue(dataList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("FalloServicio","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}