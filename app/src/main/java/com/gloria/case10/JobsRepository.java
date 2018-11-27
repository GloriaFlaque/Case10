package com.gloria.case10;


import io.reactivex.Observable;


public class JobsRepository {

    private static volatile JobsRepository ourInstance = new JobsRepository();

    static JobsRepository getInstance() {
        if (ourInstance == null) {
            synchronized (JobsRepository.class) {
                if (ourInstance == null) {
                    ourInstance = new JobsRepository();
                }
            }
        }
        return ourInstance;
    }

    private JobsRepository() {
    }

    private JobsApi jobApi = JobsApi.Factory();


    public Observable<Fortnite> getInfoFornite(String platform, String epic_nickname){
        return jobApi.getInfoFornite(platform,epic_nickname);
    }
}
