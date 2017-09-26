package ro.deutsche.mediastore;

import java.io.FileOutputStream;
import java.security.MessageDigest;

/**
 *
 * @author mihai
 */
public class Test {

		//		FileOutputStream fos = new FileOutputStream("c://prj//test.zip");
		//		BufferedOutputStream bugff = new BufferedOutputStream(fos);
		//		DigestOutputStream digest = new DigestOutputStream(bugff, MessageDigest.getInstance("MD5"));
		//		digest.on(true);
		//		GZIPOutputStream zos = new GZIPOutputStream(bugff);
		//		zos.write("gigi".getBytes());
		//		zos.close();

		//		FileOutputStream fos = new FileOutputStream("c://prj//test.zip");
		//		
		//		
		//		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		//		DigestOutputStream out = new DigestOutputStream(new ByteArrayOutputStream(), md5Digest);
		//		
		//		out.write("titi".getBytes());
		//		md5Digest.reset();
		//		
		//		out.write("titi".getBytes());
		//		md5Digest.digest();
		//		out.close();
		//	}

//	public static void main(String[] args) throws Exception {
//		MessageDigest md = MessageDigest.getInstance("SHA-256");
//		FileOutputStream fis = new FileOutputStream("c:\\prj\\loging.log");
//
//		byte[] dataBytes = new byte[1024];
//
//		int nread = 0;
//		fis.write("titi".getBytes());
//		byte[] mdbytes = md.digest();
//
//		//convert the byte to hex format method 1
//		StringBuffer sb = new StringBuffer();
//		for (int i = 0; i < mdbytes.length; i++) {
//			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//		}
//
//		System.out.println("Hex format : " + sb.toString());
//
//		//convert the byte to hex format method 2
//		StringBuffer hexString = new StringBuffer();
//		for (int i = 0; i < mdbytes.length; i++) {
//			hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
//		}
//
//		System.out.println("Hex format : " + hexString.toString());
//	}
}
