package com.ohgiraffers.run;

import com.ohgiraffers.controller.Controller;

public class Run {
    public static void main(String[] args) {
        // Controller 객체를 생성
        Controller controller = new Controller();

        // Controller 객체를 View의 생성자로 전달
        controller.view.menu();
    }
}
