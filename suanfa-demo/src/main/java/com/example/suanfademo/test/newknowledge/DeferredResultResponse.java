package com.example.suanfademo.test.newknowledge;

/**
 * @className: DeferredResultResponse
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/9
 */
import lombok.Data;
import lombok.Getter;

@Data
public class DeferredResultResponse {
    private Integer code;
    private String msg;

    public enum Msg {
        TIMEOUT("超时"),
        FAILED("失败"),
        SUCCESS("成功");

        @Getter
        private String desc;

        Msg(String desc) {
            this.desc = desc;
        }
    }
}