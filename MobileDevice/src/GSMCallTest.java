import java.util.Date;

public class GSMCallTest {
	public static void main(String[] args) {
		GSM gsm1 = new GSM("SAMSUNG S6", "Samsung", 10000000, "NVB");
		gsm1.addCall(new Call(new Date(2018,7,16),"11:17 AM","012345678",29.5F));
		gsm1.addCall(new Call(new Date(2018,8,1),"12:17 AM","0987456112",29.5F));
		gsm1.addCall(new Call(new Date(2018,8,2),"1:17 AM","013789456",29.5F));
		gsm1.addCall(new Call(new Date(2018,8,6),"9:17 AM","0159753456852",29.5F));
		gsm1.addCall(new Call(new Date(2018,8,8),"8:17 AM","0147896325",29.5F));
		gsm1.getCall("012345678");
		System.out.println(gsm1.calTotallPrice(2000.0F));

	}
}
