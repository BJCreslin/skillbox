package day1;

public class Proga {

    public static void main(String[] args) {
        //========================================
        //Делаем кофемашину с нужным приемником денег
        CafeMachine cofeMashine = new CafeMachine(new GetterMoneyAmountImplFromConsole());
        //Запускаем машину
        cofeMashine.run();
        //========================================
        //Создаем нужную фабрику для имен файлов
        FileName fileName = new FileNameWithDateAndHardcorePattern();
        //Получаем текущее имя файла
        System.out.println("Название файла: " + fileName.getFileName());
        //========================================
        //Создаем объект Скриншоттер
        ScreenShotter screenShotter = new ScreenShotter();
        //Делаем скриншот экрана
        screenShotter.doScreenshot();
        //Печатаем данные сохраненного скриншота
        System.out.println("Размер скриншота: " + screenShotter);

    }


}




