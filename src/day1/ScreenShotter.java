package day1;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Класс для снятия скриншотов
 */
public class ScreenShotter {
    private BufferedImage image;
    /**
     * Метод делающий скриншот экрана
     */
    public void doScreenshot() {
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            System.out.println("Скрншот сделан.");
        } catch (AWTException e) {
            System.out.println("Ошибка при \"скриншотировании\" :-) ");
        }
    }
    /**
     * Возвращаем размерность сохранённого скриншота
     */
    @Override
    public String toString() {
        return image.getWidth() + "x" + image.getHeight();
    }

}
