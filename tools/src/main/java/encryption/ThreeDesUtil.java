package encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class ThreeDesUtil {

    private static final String Algorithm = "DESede"; //定义加密算法,可用 DES,DESede,Blowfish

    //获取密文
    public static String getCiphertext(String text,String token){
        byte[] enk = hex(token);
        byte[] encoded = encryptMode(enk,text.getBytes());
        return Base64.encodeBase64String(encoded);
    }

    //获取明文
    public static String getText(String ciphertext,String token){
        byte[] enk = hex(token);
        byte[] reqPassword = Base64.decodeBase64(ciphertext);
        byte[] srcBytes = decryptMode(enk, reqPassword);
        return new String(srcBytes);
    }

    //keybyte为加密密钥，长度为24字节
    //src为被加密的数据缓冲区（源）
    private static byte[] encryptMode(byte[] keybyte,byte[] src){
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);//在单一方面的加密或解密
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(java.lang.Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    //keybyte为加密密钥，长度为24字节
    //src为加密后的缓冲区
    private static byte[] decryptMode(byte[] keybyte,byte[] src){
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            //解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(java.lang.Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    private static byte[] hex(String str){
        String f = DigestUtils.md5Hex(str);
        byte[] bkeys = new String(f).getBytes();
        byte[] enk = new byte[24];
        for (int i=0;i<24;i++){
            enk[i] = bkeys[i];
        }
        return enk;
    }


    public static void main(String[] args) {
        String text = "20170101360192";//明文
        String token = "sdadsasdaffqf";
        System.out.println("加密前的字符串:" + text);
        String password = getCiphertext(text, token);
        System.out.println("加密后的字符串:" + password);
        System.out.println("解密后的字符串:" + getText(password,token));
    }

}
