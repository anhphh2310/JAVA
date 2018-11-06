package MobileDevice;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GSMCallTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		GSM gsm1 = new GSM("SAMSUNG S6", "Samsung", 10000000, "NVB");
		gsm1.addCall(new Call(formatter.parse("17-08-2018"),"12:17 AM","0987456112",29.5F));
		gsm1.addCall(new Call(formatter.parse("17-05-2018"),"1:17 AM","013789456",29.5F));
		gsm1.addCall(new Call(formatter.parse("17-04-2018"),"9:17 AM","0159753456852",29.5F));
		gsm1.addCall(new Call(formatter.parse("17-08-2018"),"8:17 AM","0147896325",29.5F));
		gsm1.getCall("012345678");
		System.out.println(gsm1.calTotallPrice(2000.0F));

	}
}
