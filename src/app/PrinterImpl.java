package app;

public class PrinterImpl implements Printer {
    // Рядок 6,у мене було public class Message,вибивало помилку
    //IDE видало підсказку,на яку нажав і клас змінився на record і помилка зникла
    public record Message(String text, String sender) {
    }

    @Override
    public void print(Message message) {
        if ((message.sender() == null || message.sender().isEmpty()) &&
                (message.text() == null || message.text().isEmpty())) {
            System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
        } else if (message.sender() == null || message.sender().isEmpty()) {
            System.out.println("Анонімний користувач відправив повідомлення: " + message.text());
        } else {
            System.out.println("Користувач " + message.sender() + " відправив повідомлення: " + message.text());
        }
    }

    public static void main(String[] args) {
        Printer printer = new PrinterImpl();

        PrinterImpl.Message msg1 = new PrinterImpl.Message("Hello", "Aliona");
        printer.print(msg1);

        PrinterImpl.Message msg2 = new PrinterImpl.Message("Hi there!", null);
        printer.print(msg2);

        PrinterImpl.Message msg3 = new PrinterImpl.Message(null, null);
        printer.print(msg3);
    }
}
