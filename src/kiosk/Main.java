package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int orderCounter = 1; // 주문 카운터 번호

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //입력스케너
        Order order = new Order(); //주문 객체 생성

        // coffee 메뉴 항목 생성
        Product espresso = new Product("Espresso               ", 2.0, "상율이가 만든 에스프레소");
        Product americano = new Product("Americano              ", 2.3, "상율이가 만든 아메리카노");
        Product cafeLatte = new Product("Cafe Latte             ", 2.5, "상율이가 만든 카페라떼");
        Product caramelMacchiato = new Product("Caramel Macchiato      ", 3.0, "상율이가 만든 캐러멜 마키아토");
        Product toffeeNutLatte = new Product("Toffee Nut Latte       ", 3.0, "상율이가 만든 토피 넛 라떼");

        // tea 메뉴 항목 생성
        Product greenTea = new Product("Green tea              ", 2.5, "상율이가 만든 녹차");
        Product citrus = new Product("Citrus                 ", 2.0, "상율이가 만든 시트러스");
        Product earlGray = new Product("Earl gray              ", 2.0, "상율이가 만든 얼 그레이");
        Product peppermint = new Product("Peppermint             ", 2.0, "상율이가 만든 페퍼민트");

        // dessert 메뉴 항목 생성
        Product lemonCheesecake = new Product("Lemon Cheesecake       ", 3.5, "상율이가 만든 레몬 치즈케이크");
        Product chocolateChipCookies = new Product("Chocolate Chip Cookies ", 2.5, "상율이가 만든 초코 칩 쿠키");
        Product fudgeBrownie = new Product("Fudge Brownie          ", 1.5, "상율이가 만든 퍼지 브라우니");
        Product blueberryMuffins = new Product("Blueberry Muffins      ", 2.0, "상율이가 만든 블루베리 머핀");

        // mini snack 항목 아이템 생성
        Product croissant = new Product("Croissant              ", 2.5, "상율이가 만든 크루아상");
        Product panini = new Product("Panini                 ", 2.5, "상율이가 만든 파니니");


        // 커피 메뉴판 생성
        List<Product> coffeesMenu = new ArrayList<>();
        coffeesMenu.add(espresso);
        coffeesMenu.add(americano);
        coffeesMenu.add(cafeLatte);
        coffeesMenu.add(caramelMacchiato);
        coffeesMenu.add(toffeeNutLatte);

        // 티 메뉴판 생성
        List<Product> teasMenu = new ArrayList<>();
        teasMenu.add(greenTea);
        teasMenu.add(citrus);
        teasMenu.add(earlGray);
        teasMenu.add(peppermint);

        // 디저트 메뉴판 생성
        List<Product> dessertsMenu = new ArrayList<>();
        dessertsMenu.add(lemonCheesecake);
        dessertsMenu.add(chocolateChipCookies);
        dessertsMenu.add(fudgeBrownie);
        dessertsMenu.add(blueberryMuffins);

        // 미니스낵 메뉴판 생성
        List<Product> miniSnacksMenu = new ArrayList<>();
        miniSnacksMenu.add(croissant);
        miniSnacksMenu.add(panini);


        // 메인 메뉴판 표시
        displayMainMenu(scanner, order, coffeesMenu, teasMenu, dessertsMenu, miniSnacksMenu);

    }

    private static void displayMainMenu(
            Scanner scanner, Order order, List<Product> coffeesMenu, List<Product> teasMenu,
            List<Product> dessertsMenu, List<Product> miniSnacksMenu
            ) {
        while (true) {
            System.out.println("스파르타 버거에 오신걸 환영합니다.");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            System.out.println("\n[ YUL'S COFFEE MENU ]");
            System.out.println("1. Coffee         | 상율님이 직접 만든 커피");
            System.out.println("2. Tea            | 상율님이 직접 만든 차");
            System.out.println("3. Dessert        | 상율님이 직접 만든 수제 디저트");
            System.out.println("4. Mini Snack     | 상율님이 직접 만든 수제 과자");
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("5. Order          | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel         | 진행중인 주문을 취소합니다");

            System.out.print("\n메뉴 선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProductMenu(coffeesMenu, scanner, order);
                    break;
                case 2:
                    displayProductMenu(teasMenu, scanner, order);
                    break;
                case 3:
                    displayProductMenu(dessertsMenu, scanner, order);
                    break;
                case 4:
                    displayProductMenu(miniSnacksMenu, scanner, order);
                    break;
                case 5:
                    displayOrderScreen(order, scanner);
                    break;
                case 6:
                    displayCancelScreen(order, scanner);
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
                    break;
            }
        }
    }

    private static void displayProductMenu(List<Product> menu, Scanner scanner, Order order) {
        System.out.println("\nYUL'S COFFEE에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println("\n[ Coffees MENU ]");

        for (int i = 0; i < menu.size(); i++) {
            Product product = menu.get(i);
            System.out.println((i + 1) + ". " + product.getName() + "   | W " + product.getPrice() + " | " + product.getDescription());
        }

        System.out.print("\n메뉴 선택: ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= menu.size()) {
            Product selectedProduct = menu.get(choice - 1);
            System.out.println(selectedProduct.getName() + "을 장바구니에 넣으시겠습니까?");
            System.out.print("1. 넣기        2. 돌아가기 \n메뉴 선택: ");
            int addToCartChoice = scanner.nextInt();
            if (addToCartChoice == 1) {
                System.out.println(selectedProduct.getName() + " 가 장바구니에 추가되었습니다.");
                order.addToCart(selectedProduct);
            }
        } else {
            System.out.println("올바른 메뉴를 선택해주세요.");
        }
    }

    private static void displayOrderScreen(Order order, Scanner scanner) {
        List<Product> cart = order.getCart();
        double totalPrice = order.getTotalPrice();

        System.out.println("\n아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ Orders ]");
        for (Product product : cart) {
            System.out.println(product.getName() + "   | W " + product.getPrice() + " | " + product.getDescription());
        }
        System.out.println("\n[ Total ]");
        System.out.println("W " + totalPrice);
        System.out.println("\n1. 주문      2. 메뉴판");

        System.out.print("\n메뉴 선택: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("주문이 완료되었습니다.");
            System.out.println("대기번호는 [ " + orderCounter + " ] 번 입니다.");
            orderCounter++;
            order.clearCart();

            // 3초 대기 후 메인 메뉴판으로 이동
            try {
                Thread.sleep(3000);  // 3초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (choice == 2) {
            // 메인 메뉴판으로 돌아가는 로직 구현 필요하나 현재 없어도 메인 메뉴판으로 이동됨
        } else {
            System.out.println("올바른 메뉴를 선택해주세요.");
        }
    }

    private static void displayCancelScreen(Order order, Scanner scanner) {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.print("1. 확인        2. 취소: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            order.clearCart();
            System.out.println("진행하던 주문이 취소되었습니다.");
            // 메인 메뉴판으로 돌아가는 로직 구현 필요
        } else if (choice == 2) {
            // 메인 메뉴판으로 돌아가는 로직 구현 필요
        } else {
            System.out.println("올바른 메뉴를 선택해주세요.");
        }
    }
}
