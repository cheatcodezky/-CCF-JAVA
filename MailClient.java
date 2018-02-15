import java.util.Random;

/**
 * Created by 95112 on 2/15/2018.
 */
public class MailClient {
    private static int MAX_COUNT = 6;
    public static void main(String[] args){
        int i = 0;
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("Bank reserve the power");
        while (i < MAX_COUNT){
            mail.setAppellation(getRandString(5) + "Sir(Miss)");
            mail.setReceiver(getRandString(8) + "Sir(Miss)");
            sendMail(mail);
            i++;
        }
    }

    private static void sendMail(Mail mail) {
        System.out.println("Title :"+mail.getSubject()+"\n receiver :"+mail.getReceiver()+"\t send successfully");
    }

    private static String getRandString(int i) {
        String source = "sddsfdfdgrgrgfgfdcetrytyutyiuoiplmnbvcxzasdfghjkl";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int j = 0 ; j < i;j++){
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();   
    }
}
