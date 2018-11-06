import java.util.ArrayList;
import java.util.List;

public class GSM {

	private String gsmModel;
	private String gsmManufacture;
	private int price;
	private String gsmOwner;

	static GSM iphone4s;

	public GSM(String gsmModel, String gsmManufacture, int price, String gsmOwner) {
		super();
		this.gsmModel = gsmModel;
		this.gsmManufacture = gsmManufacture;
		this.gsmOwner = gsmOwner;
	}

	public GSM() {
		iphone4s = new GSM("Iphone 4s", "Apple", 100, "Nguyen Van A");
	}

	public String getGsmModel() {
		return gsmModel;
	}

	public void setGsmModel(String gsmModel) {
		this.gsmModel = gsmModel;
	}

	public String getGsmManufacture() {
		return gsmManufacture;
	}

	public void setGsmManufacture(String gsmManufacture) {
		this.gsmManufacture = gsmManufacture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(short price) {
		this.price = price;
	}

	public String getGsmOwner() {
		return gsmOwner;
	}

	public void setGsmOwner(String gsmOwner) {
		this.gsmOwner = gsmOwner;
	}

	@Override
	public String toString() {
		return "GSM [gsmModel=" + gsmModel + ", gsmManufacture=" + gsmManufacture + ", price=" + price + ", gsmOwner="
				+ gsmOwner + "]";
	}

	static List<Call> callHistories = new ArrayList<Call>();

	public void addCall(Call c) {
		callHistories.add(c);
	}
	
	public void deleteCall(Call c) {
		callHistories.remove(c);
	}
	
	public void clearCallHis() {
		callHistories.clear();
	}
	
	public float calTotallPrice(Float pricePerMins) {
		float totalTime = 0;
		for (int i = 0; i < callHistories.size(); i++) {
			totalTime += callHistories.get(i).getSeconds();
		}
		float price = pricePerMins*(Math.round(totalTime/60));
		return price;
	}
	
	public void getCall(String num) {
		for (int i = 0; i < callHistories.size(); i++) {
			if(callHistories.get(i).getPhoneNum().equals(num)){
				System.out.println(callHistories.get(i).toString());
			}
		}
	}
}
