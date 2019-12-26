import net.sourceforge.jFuzzyLogic.FIS;

public class ClimatControl {
    public static void main(String[] args) throws Exception {
        // Загружаем 'FCL' файл.
        String fileName = "climat.fcl";
        FIS fis = FIS.load(fileName, true);

        // Ошибка при загрузке ?
        if( fis == null )
        {
            System.err.println("Ошибка при загрузке файла: '" + fileName + "'");
            return;
        }

        // Показываем.
        fis.chart();

        // Задаем значения входных переменных.
        fis.setVariable("temperature", 10);
        fis.setVariable("humidity", 25);
        fis.setVariable("requestedTemperature", 20);
        fis.setVariable("roomVolume", 25);

        // Вычисляем.
        fis.evaluate();

        // Печатаем информацию о выходной перменной.
        System.out.println(fis.getVariable("toCool").toString());
        System.out.println(fis.getVariable("toWarm").toString());

        // Печатаем вещественное значение последней дефаззификации выходной переменной.
        System.out.println(fis.getVariable("toCool").getValue());
        System.out.println(fis.getVariable("toWarm").getValue());

        // Показываем график выходной переменной.
        fis.getVariable("toCool").chartDefuzzifier(true);
        fis.getVariable("toWarm").chartDefuzzifier(true);

        // Печатаем набор правил.
        System.out.println(fis);
    }
}
