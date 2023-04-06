package com.example.suanfademo.test.newknowledge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/deferred-result")
public class DeferredResultController {

    @Autowired
    private DeferredResultService deferredResultService;

    /**
     * 为了方便测试，简单模拟一个
     * 多个请求用同一个requestId会出问题
     */
    private final String requestId = "haha";


    @GetMapping(value = "/get")
    public DeferredResult<DeferredResultResponse> get(@RequestParam(value = "timeout", required = false, defaultValue = "10000") Long timeout) {
        DeferredResult<DeferredResultResponse> deferredResult = new DeferredResult<>(timeout);

        deferredResultService.process(requestId, deferredResult);

        return deferredResult;
    }

    /**
     * 设置DeferredResult对象的result属性，模拟异步操作
     *
     * @param desired
     * @return
     */
    @GetMapping(value = "/result")
    public String settingResult(@RequestParam(value = "desired", required = false, defaultValue = "成功") String desired) {
        DeferredResultResponse deferredResultResponse = new DeferredResultResponse();
        if (DeferredResultResponse.Msg.SUCCESS.getDesc().equals(desired)) {
            deferredResultResponse.setCode(HttpStatus.OK.value());
            deferredResultResponse.setMsg(desired);
        } else {
            deferredResultResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            deferredResultResponse.setMsg(DeferredResultResponse.Msg.FAILED.getDesc());
        }
        deferredResultService.settingResult(requestId, deferredResultResponse);

        return "Done";
    }

    @GetMapping
    public DeferredResult<List<String>> test() {
        DeferredResult<List<String>> objectDeferredResult = new DeferredResult<>(3000L);
        ArrayList<String> strings = new ArrayList<>();
        new Thread(()->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            strings.add("222");
            strings.add("333");
            strings.add("444");
            strings.add("555");
            strings.add("666");
            System.out.println("------------------hhaha---------------");
            objectDeferredResult.setResult(strings);
        }).start();
        //onCompletion不代表处理成功，仅仅是接口调用完成时触发
        objectDeferredResult.onCompletion(()->{
            System.out.println("hahaha = " + "hahahaha");
        });
        objectDeferredResult.onTimeout(()->{
            System.out.println("failure = " + "failurefailurefailurefailure");
        });
//        String result = (String) objectDeferredResult.getResult();
//        System.out.println("result = " + result);

        return objectDeferredResult;
    }


    /*@GetMapping("/handleReqDefResult")
    public DeferredResult<String> handleReqDefResult(){
        long timeoutValue = 4700;//超时时间.
        DeferredResult<String> deferredResult = new DeferredResult<>(timeoutValue);

        new Thread(){
            @Override
            public void run() {
                //执行耗时的逻辑
                try {
                    //休眠n秒钟进行模拟业务代码.
                    TimeUnit.SECONDS.sleep(new Random().nextInt(7));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //返回结果.
                deferredResult.setResult("love ~ "+new Date());
            }
        }.start();

        return deferredResult;
    }*/

}