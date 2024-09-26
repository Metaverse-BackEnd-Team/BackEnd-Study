package com.ohgiraffers.run;

import com.ohgiraffers.controller.Controller;

public class Run {
    public static void main(String[] args) {
        // Controller 객체를 생성
        Controller cr = new Controller();
        cr.view.menu();
    }
}
