package test.lzb.web.boss;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class test {
	/**
	 * 加密的方法是（3次md5迭代，用户名+随机数当作盐），通过shiro提供的通用散列来实现：
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String algorithmName = "md5";
		String username = "刘";
		String password = "123456";
//		String salt1 = username;
//		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		int hashIterations = 3;
		SimpleHash hash = new SimpleHash(algorithmName, password, null, hashIterations);
		String encodedPassword = hash.toHex();
		System.out.println(encodedPassword);
//		System.out.println(salt2);
	}
}
