package com.ohgiraffers.view;

import com.ohgiraffers.controller.Controller;

public class View {
    private Controller cr;

    public View(Controller controller) {
        this.cr = controller;
    }

    public void menu() {
        System.out.println();
        System.out.println();
        System.out.println("------------------------------");
        if (!cr.isNotice) {
            System.out.println("공지사항 내용 :: " + "없습니다.");
        } else {
            System.out.println("공지사항 내용 :: " + cr.noticeText);
        }
        System.out.println("------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("0. 목록보기");
        System.out.println("1. 등록하기");
        System.out.println("2. 수정하기");
        System.out.println("3. 삭제하기");
        System.out.println();
        System.out.print("해당 메뉴를 입력하여 주십시오");
        cr.GetNumber();  // cr 객체를 사용하여 함수 호출
    }
}


