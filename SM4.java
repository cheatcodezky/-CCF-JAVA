import java.io.IOException;
import java.security.MessageDigest;
import java.util.Calendar;

import com.cclab.cloudstorage.security.sm3_c.SM3Digest;

public class SM4 {

	/**
	 * ������Ϣ����Կ����־��1Ϊ���ܣ�0Ϊ���ܣ� ����ӽ��ܺ����Ϣ
	 */
	public String sm4(String in, byte[] key, int flag) {
		SMS4 sm4 = new SMS4();
		if (flag == 1) {
			int inlen = in.getBytes().length;
			int inlenadd = inlen % 16;
			if (inlenadd != 0) {
				byte[] in_byte = new byte[inlen + 16 - inlenadd];
				for (int i = 0; i < inlen; i++) {
					in_byte[i] = in.getBytes()[i];
				}
				for (int i = 0; i < (16 - inlenadd); i++) {
					in_byte[inlen + i] = (byte) '0';
				}
				byte[] out = new byte[in_byte.length];
				sm4.sms4(in_byte, in_byte.length, key, out, 1);

				String result = "";
				String[] out_s = new String[out.length];
				for (int i = 0; i < out.length; i++) {
					out_s[i] = Integer.toHexString(out[i] & 0xFF).toUpperCase();
					if (out_s[i].length() < 2) {
						out_s[i] = "0" + out_s[i];
					}
					result = result + out_s[i];
				}

				return result;
			} else {
				byte[] out = new byte[inlen];
				sm4.sms4(in.getBytes(), inlen, key, out, 1);
				String result = "";
				String[] out_s = new String[out.length];
				for (int i = 0; i < out.length; i++) {
					out_s[i] = Integer.toHexString(out[i] & 0xFF);
					if (out_s[i].length() < 2) {
						out_s[i] = "0" + out_s[i];
					}
					result = result + out_s[i];
				}

				return result;
			}
		} else if (flag == 0) {
			byte[] in_b = HexString2Bytes(in);
			byte[] out = new byte[in_b.length];
			sm4.sms4(in_b, in_b.length, key, out, 0);
			String out_s = new String(out);
			return out_s;
		} else
			return "error";

	}

	/**
	 * ������ASCII�ַ��ϳ�һ���ֽڣ� �磺"EF"--> 0xEF
	 * 
	 * @param src0
	 *            byte
	 * @param src1
	 *            byte
	 * @return byte
	 */
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	/**
	 * ��ָ���ַ���src����ÿ�����ַ��ָ�ת��Ϊ16������ʽ �磺"2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
	 * 0xD9}
	 * 
	 * @param src
	 *            String
	 * @return byte[]
	 */
	public static byte[] HexString2Bytes(String src) {
		byte[] ret = new byte[src.length() / 2];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < src.length() / 2; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	/**
	 * ���SM4��Կ
	 * 
	 * @param IMEI
	 * @param PIN
	 * @return byte
	 */
	public byte[] key(String IMEI, String PIN) {

		String in = IMEI + PIN + gettime();
		System.out.println("������Կʹ�õ�SM3���룺"+in);
		SM3Digest sm3 = new SM3Digest();
		byte[] sm3_b = null;

		try {
			sm3_b = sm3.SM3(in.getBytes());
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(sm3_b);
			byte[] dataMD5 = messageDigest.digest();
			return dataMD5;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * �ֽ�ת��Ӧ��ʮ���������ַ���
	 * 
	 * @param �ֽ�����
	 * @return ʮ�����������ַ���
	 */
	public String bytetoString(byte[] in) {

		String result = "";
		String[] out_s = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out_s[i] = Integer.toHexString(in[i] & 0xFF);
			if (out_s[i].length() < 2) {
				out_s[i] = "0" + out_s[i];
			}
			result = result + out_s[i];
		}
		return result;

	}

	/**
	 * ��õ�ǰʱ����ַ���
	 * 
	 * @param
	 * @return ʱ���ַ�������ȷ������
	 */
	public static String gettime() {

		Calendar c = Calendar.getInstance();//
		int yeari = c.get(Calendar.YEAR); // int��������ͳһʱ��
		int monthi = c.get(Calendar.MONTH) + 1; // 0��ʾ1�£�����Ҫ+1
		int datei = c.get(Calendar.DATE);
		int houri = c.get(Calendar.HOUR_OF_DAY);
		int minutei = c.get(Calendar.MINUTE);

		String year = String.valueOf(yeari); // String�������ڱ���

		String month = new String();
		if (monthi < 10) {
			month = "0" + String.valueOf(monthi);
		} else
			month = String.valueOf(monthi);

		String date = new String();
		if (datei < 10) {
			date = "0" + String.valueOf(datei);
		} else
			date = String.valueOf(datei);

		String hour = new String();
		if (houri < 10) {
			hour = "0" + String.valueOf(houri);
		} else
			hour = String.valueOf(houri);

		String minute = new String();
		if (minutei < 10) {
			minute = "0" + String.valueOf(minutei);
		} else
			minute = String.valueOf(minutei);

		String time_s = year + month + date + hour + minute;
		return time_s;

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		byte[] key = { 0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab,
				(byte) 0xcd, (byte) 0xef, (byte) 0xfe, (byte) 0xdc,
				(byte) 0xba, (byte) 0x98, 0x76, 0x54, 0x32, 0x10 };

		SM4 sm4key = new SM4();
		byte[] key2 = sm4key.key("just love", "tang lin");


	}
}
