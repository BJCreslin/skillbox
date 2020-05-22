package day1;

import java.util.List;
import java.util.Scanner;

public class CafeMachine {
    /**
     * Класс Кофемашины.
     * Для использования нужна в конструктор передать объект, реализующий GetterMoneyAmount, через который получают деньги
     * Для запуска метод - run()
     */

    private final List<Beverage> beverageList;
    private final GetterMoneyAmount getterMoneyAmount;

    public CafeMachine(GetterMoneyAmount getterMoneyAmount) {
        this.getterMoneyAmount = getterMoneyAmount; // выбираем систему получения денег
        this.beverageList = fillMachineWithDrinks(); //Наполняем аппарат напитками
        System.out.println("Кофе-машина"); //машина готова к работе
    }

    /**
     * Метод работы кофе-машины
     */
    public void run() {
        drinkBeverageFromMachine(getterMoneyAmount.getMoney());
    }

    private List<Beverage> fillMachineWithDrinks() {
        return List.of(
                new Beverage("капучино", 150),
                new Beverage("эспрессо", 80),
                new Beverage("воду", 20),
                new Beverage("молоко", 35)
        );
    }

    private void drinkBeverageFromMachine(int moneyAmount) {
        if (beverageList.stream().filter(x -> moneyAmount >= x.getPrice()).
                peek(x -> System.out.println("Вы можете купить " + x.getName())).count() == 0) {
            messageToPauper();
        }
    }

    private void messageToPauper() {
        System.out.println("Нищеброд, ты ничего не сможешь заказать у нас.");
    }
}

/**
 * Класс объекта -напиток.
 */
class Beverage {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

/**
 * Интерфейс "получателя денег".
 */
interface GetterMoneyAmount {
    int getMoney();
}

/**
 * Получатель наличных денег
 */
class GetterMoneyAmountImplFromConsole implements GetterMoneyAmount {

    @Override
    public int getMoney() {
        int resultMoney = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("ВВедите количество денег");
            if (scanner.hasNextInt()) {
                resultMoney = scanner.nextInt();
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
        return resultMoney;
    }
}

