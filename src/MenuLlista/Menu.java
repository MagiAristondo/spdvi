package MenuLlista;

import java.util.Scanner;

public class Menu
{
    final int tamanyMenu = 20;
    String header;
    String[] options;
    static LlegirEscriure combo;

    public Menu(String header, String ... options)
    {
        this.header = header;
        this.options = options;
    }

    public void show()
    {
        System.out.println("=".repeat(tamanyMenu));
        System.out.println(header);
        System.out.println("=".repeat(tamanyMenu));

        for (int i = 0; i < options.length; i++)
        {
            System.out.println(i + 1 + " → " + options[i]);
            if (i < options.length - 1) System.out.println("·".repeat(tamanyMenu));
        }

        System.out.println("=".repeat(tamanyMenu));
        System.out.println("0 → Exit");
        System.out.println("=".repeat(tamanyMenu) + "\n");
    }

    public String getOption()
    {
        Scanner get = new Scanner(System.in);

        String option = " ";

        try
        {
            option = get.next();
        }
        catch (Exception e)
        {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            get.nextLine(); // Limpiar el búfer del scanner para evitar bucles infinitos
        }

        return option;
    }

    public static void main(String[] args)
    {
        Menu menu = new Menu("Llista tasques", "Add", "Print", "PrintAll", "Done", "ReOrder", "Quit");

        combo = new LlegirEscriure();

        String answer = " ";
        while (answer.equals(" ")){
            menu.show();

            answer = menu.getOption();

            switch (answer) {
                case "add" -> combo.add();
                case "print" -> combo.print();
                case "printAll" -> combo.printAll();
            }
        }
    }
}
