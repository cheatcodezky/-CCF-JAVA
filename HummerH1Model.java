/**
 * Created by 95112 on 2/13/2018.
 */
public class HummerH1Model extends HummerModel {
    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void stop() {
        System.out.println("Car stop");
    }

    @Override
    public void alarm() {
        System.out.println("Car alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("Car engineBoom");
    }

    private boolean ifAlarm = true;
    public void setIfAlarm(boolean ifAlarm)
    {
        this.ifAlarm = ifAlarm;
    }
    @Override
    protected boolean isAlarm(){
        return ifAlarm;
    }
}
