/**
 * Created by 95112 on 2/2/2018.
 */
public class NovelBook implements IBook {
    private String name;
    private int price;
    private String author;
    public NovelBook(String _name, int _price, String _author)
    {
        this.name = _name;
        this.price = _price;
        this.author = _author;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
