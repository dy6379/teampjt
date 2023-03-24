package library;

public class Library {
	private Integer id;
	private String name;
	private String type;
	private Integer count;
	private String address;
	private String phoneNum;
	private String homePage;

	public Library(Integer id, String name, String type, Integer count, String address, String phoneNum,
			String homePage) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.count = count;
		this.address = address;
		this.phoneNum = phoneNum;
		this.homePage = homePage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	
}
