/**
 * Created by 95112 on 2/4/2018.
 */
public abstract class Creator {
    public <T extends Product> T createProduct(Class<T> c){
        Product product = null;
        try{
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product  ;
    }
}
