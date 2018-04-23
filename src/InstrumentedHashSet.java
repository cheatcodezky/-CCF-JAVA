import java.util.Collection;
import java.util.Set;

/**
 * Created by 95112 on 3/9/2018.
 */
public class InstrumentedHashSet<E> extends ForwardingSet<E>{
    private int addCount = 0;
    public InstrumentedHashSet(Set<E> s) {
        super(s);
    }
    @Override public boolean add(E e){
        addCount++;
        return  super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c)
    {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount()
    {
        return addCount;
    }


}
