package vo.member;

public class MemberVo {
	private String id;
	private String pw;
	private String name;
	private String nik;
	private String email;
	private String tel;
	private int admin;
	
	public MemberVo() {}
	
	public MemberVo(String id, String pw, String name, String nik, String email, String tel, int admin) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nik = nik;
		this.email = email;
		this.tel = tel;
		this.admin = admin;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pw=" + pw + ", name=" + name + ", nik=" + nik + ", email=" + email + ", tel="
				+ tel + ", admin=" + admin + "]";
	}
	
	
	
}
