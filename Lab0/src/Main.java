public class Main {
    public static void main(String[] args) {
        Shape square = new Square(4);
        Shape rectangle = new Rectangle(3, 4);
        AreaCalculator areaCalculator = new AreaCalculator();

        System.out.println("Square area = " + areaCalculator.calculateArea(square));
        System.out.println("Rectangle area = " + areaCalculator.calculateArea(rectangle));
    }
}
