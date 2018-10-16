import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by 95112 on 2/2/2018.
 */
public class BookStore {
    private final static ArrayList<IBook> bookList = new ArrayList<>();
    static{
        bookList.add (new NovelBook("Merry me",16,"Jack"));
        bookList.add(new NovelBook("Tom and Jerry", 14, "Tom Handisen"));
        bookList.add(new NovelBook("First Blood",35, "Adsen"));
    }
    public static void main(String[] args){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        System.out.println("---------------------BookStory Log-----------------------");
        for (IBook book : bookList){
            System.out.println("Book Name: "+ book.getName() +
                    "\tBook Price: " + book.getPrice() +
                    "\tBook Author: " + book.getAuthor());
        }

    }
    public void test(){
    	System.out.println("Test publick key");
    }
}
