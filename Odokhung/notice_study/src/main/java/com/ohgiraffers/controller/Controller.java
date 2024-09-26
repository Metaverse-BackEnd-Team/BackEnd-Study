package com.ohgiraffers.controller;

import com.ohgiraffers.view.View;

import java.util.Scanner;

public class Controller {
    public boolean isNotice = false;
    public String noticeText = "";
    public View view;

    public Controller() {
        this.view = new View(this);
    }

    public void GetNumber() {
        Scanner scanner = new Scanner(System.in);
        int seletNumber = scanner.nextInt();
        switch (seletNumber) {
            case 0:
                AddNoticeListInfo();
                break;
            case 1:
                InsertNotice();
                break;
            case 2:
                UpdateNotice();
                break;
            case 3:
                DeleteNotice();
                break;
            default:
                System.out.println("wrong number");
                break;
        }
    }



// 이미 있는 공지사항의 내용을 봅니다.
    public void AddNoticeListInfo() {
        if (!isNotice) {
            System.out.println("공지사항이 존재하지 않습니다.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("공지사항을 등록하러 이동하시겠습니까?");
            System.out.println("계속 하시려면 1번 아니면 2번을 입력하여 주십시오");
            int insertMove = scanner.nextInt();
            switch (insertMove) {
                case 1:
                    InsertNotice();
                    break;
                case 2:
                    AddNoticeListInfo();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    view.menu();
                    break;
            }
        } else {
            System.out.println("공지사항이 존재 합니다.");
            System.out.println("현재 공지사항은 다음과 같습니다.");
            System.out.println(noticeText);
            System.out.println("처음으로 돌아가실려면 1번을 현재 공지사항 내용을 바꾸시려면 2번 수정하시려면 3번 삭제하시려면 4번을 눌러주십시오");
            Scanner scanner = new Scanner(System.in);
            int insertMove = scanner.nextInt();
            switch (insertMove) {
                case 1:
                    view.menu();
                    break;
                case 2:
                    if (isNotice) {
                        System.out.println("이미 등록이 되어 있는 공지사항이 존재하여 수정기능으로 이동합니다.");
                        UpdateNotice();
                        break;
                    } else {
                        InsertNotice();
                    }

                    break;
                case 3:
                    UpdateNotice();
                    break;
                case 4:
                    DeleteNotice();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    view.menu();
                    break;
            }
        }
    }

    // 새로운 공지사항을 등록합니다.
    public void InsertNotice() {
        System.out.println("안내말씀 드립니다.");
        System.out.println("공지사항은 현재 1개만 등록할수있습니다.");
        System.out.println("계속 진행하시겠습니까?");
        System.out.println("계속 하려면 1 아니면 2를 눌러주십시오");
        Scanner scanner = new Scanner(System.in);
        int intInsert = scanner.nextInt();
        switch (intInsert) {
            case 1:
                InsertNoticeStart();
                break;
            case 2:
                AddNoticeListInfo();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                view.menu();
                break;
        }
    }

    public void InsertNoticeStart() {
        System.out.println("공지사항 작성을 시작합니다.");
        System.out.println("입력할 공지사항의 내용을 입력하여 주십시오");
        Scanner scanner = new Scanner(System.in);
        noticeText = scanner.nextLine();
        System.out.println("입력하신 내용은 다음과 같습니다.");
        System.out.println(noticeText);
        System.out.println("현재 입력하신 내용이 맞습니까?");
        System.out.println("맞으면 1 아니면 2를 눌러주십시오");
        Scanner scanner1 = new Scanner(System.in);
        int insertMove = scanner1.nextInt();
        switch (insertMove) {
            case 1:
                isNotice = true;
                System.out.println("입력하신 공지사항이 저장되었습니다.");
                System.out.println("처음으로 돌아갑니다.");
                AddNoticeListInfo();
                break;
            case 2:
                System.out.println("다시 입력하여 주십시오");
                InsertNoticeStart();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                view.menu();
                break;
        }
    }

    // 이미 등록이 되어 있는 공지사항을 수정합니다.
    public void UpdateNotice(){
        if (!isNotice) {
            System.out.println("수정할 공지사항이 존재하지 않습니다.");
            view.menu();
        } else {
            System.out.println("현재 공지사항: " + noticeText);
            System.out.println("새로운 공지사항 내용을 입력해주세요:");

            Scanner sc = new Scanner(System.in);
            String newNoticeText = sc.nextLine();

            System.out.println("새로운 공지사항은 다음과 같습니다:");
            System.out.println(newNoticeText);
            System.out.println("이대로 수정하시겠습니까? (1: 예 / 2: 아니오)");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    noticeText = newNoticeText;
                    System.out.println("공지사항이 성공적으로 수정되었습니다.");
                    break;
                case 2:
                    System.out.println("공지사항 수정을 취소합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴로 돌아갑니다.");
                    break;
            }
            view.menu();
        }
    }

    // 이미 등록이 되어 있는 공지사항을 삭제합니다.
    public void DeleteNotice() {
        if (!isNotice) {
            System.out.println("삭제할 공지사항이 존재하지 않습니다.");
            view.menu();
        } else {
            System.out.println("현재 공지사항: " + noticeText);
            System.out.println("정말로 공지사항을 삭제하시겠습니까? (1: 예 / 2: 아니오)");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    noticeText = "";
                    isNotice = false;
                    System.out.println("공지사항이 성공적으로 삭제되었습니다.");
                    break;
                case 2:
                    System.out.println("공지사항 삭제를 취소합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 메뉴로 돌아갑니다.");
                    break;
            }
            System.out.println("처음으로 돌아갑니다.");
            view.menu();
        }


    }
}