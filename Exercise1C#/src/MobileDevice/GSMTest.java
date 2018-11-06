package MobileDevice;
import java.util.ArrayList;
import java.util.List;

public class GSMTest {

	public static void main(String[] args) {
		List<GSM> gsms = new ArrayList<GSM>();
		GSM gsm = new GSM();
		GSM gsm1 = new GSM("SAMSUNG S6","Samsung",10000000,"NVB");
		GSM gsm2 = new GSM("SAMSUNG S7","Samsung",12000000,"NVB");
		GSM gsm3 = new GSM("SAMSUNG S8","Samsung",14000000,"NVB");
		GSM gsm4 = new GSM("SAMSUNG S9","Samsung",18000000,"NVB");
		gsms.add(gsm1);
		gsms.add(gsm2);
		gsms.add(gsm3);
		gsms.add(gsm4);
		for (int i = 0; i < gsms.size(); i++) {
			System.out.println(gsms.get(i).toString());
		}
		System.out.println(gsm.iphone4s.toString());
	}
}
