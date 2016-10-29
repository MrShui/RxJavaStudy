package com.chinatelecom.rxjavastudy.api;

import com.chinatelecom.rxjavastudy.ResultModel;
import com.chinatelecom.rxjavastudy.api.bean.req.ReqProfessorInteraction;
import com.chinatelecom.rxjavastudy.api.bean.resp.ResProfessorInteraction;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Shui on 16/10/28.
 */

public interface Api {
    /**
     * 专家互动
     *
     * @return
     */
    @POST("get-info")
    Observable<ResultModel<List<ResProfessorInteraction>>> professorInteraction(@Body ReqProfessorInteraction reqProfessorInteraction);
}
