public class Main {
    public static void main(String[] args) {
        var emp = new EmpleadoComision("Jose", 10000, 5);
        System.out.println(emp);
        emp.vender(10_000);
        emp.vender(30_000);
        System.out.println(emp);
        System.out.println(emp.getSalario());
    }
}
