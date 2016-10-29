package com.chinatelecom.rxjavastudy;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.chinatelecom.rxjavastudy.api.ApiHelper;
import com.chinatelecom.rxjavastudy.api.ResultSubscriber;
import com.chinatelecom.rxjavastudy.api.bean.req.ReqProfessorInteraction;
import com.chinatelecom.rxjavastudy.api.bean.resp.ResProfessorInteraction;
import com.chinatelecom.rxjavastudy.api.rxhelper.RxResultHelper;
import com.chinatelecom.rxjavastudy.api.rxhelper.RxSchedulersHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);
        Log.i("TAG", "这尼玛到底是哪个界面");
        method12();
    }

    /**
     * create最基本的创建方法
     */
    private void method1() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("呵呵");
                subscriber.onNext("哈哈");
                subscriber.onNext("你妹的");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i("TAG", "onCompleted()：");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("TAG", "onError()：");
            }

            @Override
            public void onNext(String s) {
                Log.i("TAG", "onNext()：" + s);
            }
        });
    }

    /**
     * just，按顺序输出
     */
    private void method2() {
        Observable.just("呵呵", "哈哈", "你妹的")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TAG", "onCompleted()：");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "onError()：");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("TAG", "onNext()：" + s);
                    }
                });
    }

    /**
     * from，顺序输出一个数组
     */
    private void method3() {
        Observable.from(new String[]{"呵呵", "哈哈", "你妹的"})
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.i("TAG", "onCompleted()：");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("TAG", "onError()：");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("TAG", "onNext()：" + s);
                    }
                });
    }

    /**
     * 不完整回调，Action1相当于onNext()
     */
    private void method4() {
        Observable.from(new String[]{"呵呵", "哈哈", "你妹的"})
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "onNext()：" + s);
                    }
                });
    }

    /**
     * 线程调度
     */
    private void method5() {
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher, getTheme());
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Drawable>() {
                    @Override
                    public void call(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "出错了！", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * map转换的使用
     */
    private void method6() {
        Observable.just(1, 2, 3)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        switch (integer) {
                            case 1:
                                return "呵呵";
                            case 2:
                                return "哈哈";
                            case 3:
                                return "去你妹";
                        }
                        return "默认的";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "s:" + s);
                    }
                });
    }

    /**
     * flatMap的使用
     */
    private void method7() {
        List<Student> students = getData();
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        Log.i("TAG", "courseName:" + course.getCourseName());
                    }
                });
    }

    public List<Student> getData() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("小张");
        student.setAge(18);

        List<Course> courses = new ArrayList<>();
        Course course = new Course();
        course.setCourseName("语文");
        course.setTeacher("李老师");

        Course course2 = new Course();
        course2.setCourseName("数学");
        course2.setTeacher("王老师");

        courses.add(course);
        courses.add(course2);
        student.setCourses(courses);


        Student student2 = new Student();
        student2.setName("小李");
        student2.setAge(23);

        List<Course> courses3 = new ArrayList<>();
        Course course3 = new Course();
        course3.setCourseName("语文");
        course3.setTeacher("李老师");


        Course course4 = new Course();
        course4.setCourseName("数学");
        course4.setTeacher("王老师");

        courses3.add(course);
        courses3.add(course4);
        student2.setCourses(courses3);

        students.add(student);
        students.add(student2);

        return students;
    }

    /**
     * doOnNext使用
     */
    private void method8() {
        Observable.from(new String[]{"1", "2", "3"})
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "doOnNext():" + s);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "call():" + s);
                    }
                });
    }

    //************************************操作符的使用************************************

    /**
     * merge操作符使用，A合并B：A的所有元素在前，B的所有元素在后
     */
    private void method9() {
        String[] strs1 = new String[]{"小李", "小王", "小水"};
        String[] strs2 = new String[]{"呵呵", "哈哈", "你妹"};
        Observable.merge(Observable.from(strs1), Observable.from(strs2))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "call():" + s);
                    }
                });
    }

    /**
     * zip操作符使用
     */
    private void method10() {
        String[] strs1 = new String[]{"小李", "小王", "小水"};
        String[] strs2 = new String[]{"呵呵", "哈哈", "你妹"};
        Observable.zip(Observable.from(strs1), Observable.from(strs2), new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + "," + s2;
            }
        })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("TAG", "call():" + s);
                    }
                });
    }

    /**
     * compose操作符使用
     */
    private void method11() {
        ResultModel<String> model = new ResultModel<>();
        model.setSuccess(false);
        model.setErrorCode("10003");
        model.setErrorMsg("服务器内部错误");
        model.setData("哈哈，网络请求成功了！");

        Observable.just(model)
                .compose(RxSchedulersHelper.<ResultModel<String>>io_main())
                .compose(RxResultHelper.<String>handleResult())
                .subscribe(new ResultSubscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        Log.i("TAG", "处理的结果是：" + s);
                    }
                });
    }

    /**
     * 测试retrofit2
     */
    private void method12() {
        ReqProfessorInteraction reqProfessorInteraction = new ReqProfessorInteraction();
        reqProfessorInteraction.setId("11");
        ApiHelper.getApi().professorInteraction(reqProfessorInteraction)
                .compose(RxSchedulersHelper.<ResultModel<List<ResProfessorInteraction>>>io_main())
                .compose(RxResultHelper.<List<ResProfessorInteraction>>handleResult())
                .subscribe(new ResultSubscriber<List<ResProfessorInteraction>>() {
                    @Override
                    public void onNext(List<ResProfessorInteraction> resProfessorInteractions) {
                        Log.i("TAG", "resProfessorInteractions:" + resProfessorInteractions);
                    }
                });
    }

}
