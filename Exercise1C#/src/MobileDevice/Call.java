package MobileDevice;
import java.util.Date;

public class Call {
	private Date date;
	private String time;
	private String phoneNum;
	private float seconds;

	public Call(Date date, String time, String phoneNum, float seconds) {
		super();
		this.date = date;
		this.time = time;
		this.phoneNum = phoneNum;
		this.seconds = seconds;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public float getSeconds() {
		return seconds;
	}

	public void setSeconds(float seconds) {
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return "Call [date=" + date + ", time=" + time + ", phoneNum=" + phoneNum + ", seconds=" + seconds + "]";
	}

}
