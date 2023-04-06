package com.example.suanfademo.day02;

import lombok.Data;

/**
 * @className: Boy
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/2
 */
@Data
class Boy{
    private int no;
    /**
     * 默认空
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }
}