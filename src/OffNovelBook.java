/**
 * Created by 95112 on 2/2/2018.
 */
public class OffNovelBook extends NovelBook {
    public OffNovelBook(String _name, int _price, String _author) {
        super(_name, _price, _author);
    }
    @Override
    public int getPrice(){
        int originPrice = super.getPrice();
        if (originPrice >= 40)
            return (int)(originPrice*0.9);
        else
            return (int)(originPrice*0.8);
    }
}
