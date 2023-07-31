package kh.test.jdbckh.common.filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordWrapper extends HttpServletRequestWrapper {

	public PasswordWrapper(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		System.out.println("[ejkim] 암호화전" +name.length()+", "+name);
		if(name != null && name.equals("pwd")) { // request.getParameter("pwd")가 호출되면
			name= getSha512(super.getParameter(name));	// 88자 String
		}else { // request.getParameter("pwd외다른이름") 가 호출되면
			name= super.getParameter(name);
		}
		System.out.println("[ejkim] 암호화후" +name.length()+", "+name);
		return name;
	}
	private String getSha512(String pwd) {
		String result = null;
		// SHA-512 암호화메소드
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");	// Singleton이다 new 사용해서 생성하지 않는다.
			byte[] pwdBytes = pwd.getBytes(Charset.forName("UTF-8"));	// UTF-8 모양으로 생겼을테니 그걸 가지고 byte 모양으로 만들어줘
			md.update(pwdBytes);	// 암호화 함.
			// 암호화된 byte[]를 다시 String 형태로 변형시켜야 한다.
			result = Base64.getEncoder().encodeToString(pwdBytes);	//88자 String 형태
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
}
