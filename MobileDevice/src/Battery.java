
public class Battery {

	enum BatteryModel {
		LiOn, NiMH, NiCd
	}

	private BatteryModel batteryModel;
	private short hourIdle;
	private short hourTalk;

	public Battery(BatteryModel batteryModel, short hourIdle, short hourTalk) {
		super();
		this.batteryModel = batteryModel;
		this.hourIdle = hourIdle;
		this.hourTalk = hourTalk;
	}

	public BatteryModel getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(BatteryModel batteryModel) {
		this.batteryModel = batteryModel;
	}

	public short getHourIdle() {
		return hourIdle;
	}

	public void setHourIdle(short hourIdle) {
		this.hourIdle = hourIdle;
	}

	public short getHourTalk() {
		return hourTalk;
	}

	public void setHourTalk(short hourTalk) {
		this.hourTalk = hourTalk;
	}

	
}
