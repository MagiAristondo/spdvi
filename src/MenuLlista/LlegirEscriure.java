package MenuLlista;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LlegirEscriure
{
    List<Linia> llista = new ArrayList<>();

    public LlegirEscriure() {}

    public void add()
    {
        try (Scanner sc = new Scanner(new File("llista.txt")))
        {
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] dades = line.split("[|]");

                Linia linia = new Linia(dades[0], Integer.parseInt(dades[1]));
                if (seek(linia)) llista.add(linia);
            }
        }
        catch (Exception e)
        {
            System.err.println("Something went wrong while reading file");
        }
    }


    public void printAll()
    {
        try (PrintWriter pw = new PrintWriter(new File("llista.csv")))
        {
            for (Linia linia : llista)
            {
                pw.printf("%s\n", linia.getTasca());
            }
        }
        catch (Exception e)
        {
            System.err.println("Something went wrong while writing file");
        }
    }

    public void print()
    {
        try (PrintWriter pw = new PrintWriter(new File("llista.csv")))
        {
            for (Linia linia : llista)
            {
                if (!seek(linia)) pw.printf("%d - %s\n", linia.getPos(), linia.getTasca());
            }
        }
        catch (Exception e)
        {
            System.err.println("Something went wrong while writing file");
        }
    }

    public boolean seek(Linia linia)
    {
        for (Linia linia1 : llista)
            if (linia1.getTasca() == linia.getTasca()) return false;
        return true;
    }

    public static void main(String[] args)
    {
        new LlegirEscriure();
    }
}
