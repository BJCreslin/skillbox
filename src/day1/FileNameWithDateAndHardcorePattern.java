package day1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для фабрики, делающей названия файлов, зависящих от текущего времени, в заданном формате
 */
public class FileNameWithDateAndHardcorePattern implements FileName {
    private final SimpleDateFormat formatter;

    public FileNameWithDateAndHardcorePattern() {
        formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    }

    @Override
    public String getFileName() {
        return formatter.format(new Date()) + ".png";
    }
}

/**
 * Интерфейс для фабрик, делающих имена файлов
 */
interface FileName {
    String getFileName();
}
