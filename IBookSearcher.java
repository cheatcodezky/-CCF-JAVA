import java.util.Map;

/**
 * Created by 95112 on 2/2/2018.
 */
public interface IBookSearcher {
    void searchByAuthor();
    void searchByTitle();
    void searchByPublisher();
    void searchByCatagory();
    void complexSearch(Map map);
}
