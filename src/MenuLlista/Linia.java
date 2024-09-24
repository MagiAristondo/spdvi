package MenuLlista;

public class Linia
{
    private String tasca;
    private int pos; // posició ordinal de la tasca

    public Linia(String tasca, int pos)
    {
        this.tasca = tasca;
        this.pos = pos;
    }

    public String getTasca()
    {
        return tasca;
    }

    public void setTasca(String tasca)
    {
        this.tasca = tasca;
    }

    public int getPos()
    {
        return pos;
    }

    public void setPos(int pos)
    {
        this.pos = pos;
    }
}
