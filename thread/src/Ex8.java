public class Ex8 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        User1 user1Thread = new User1();
        user1Thread.setCalculator(calculator);
        user1Thread.start();

        User2 user2Thread = new User2();
        user2Thread.setCalculator(calculator);
        user2Thread.start();

    }
}
