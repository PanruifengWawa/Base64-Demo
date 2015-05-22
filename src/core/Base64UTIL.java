package core;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
/** 
 * ʹ��base64���뷽ʽ���ļ����ַ������б������ 
 */  
public class Base64UTIL {  
	private String removeLine(String str){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		String dest = m.replaceAll("");
		return dest;
	}
  
	public String encodeImgageToBase64(File imageFile) {// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ���ֽ�����Base64����
        BASE64Encoder encoder = new BASE64Encoder();
        
        String str =  encoder.encode(outputStream.toByteArray());// ����Base64��������ֽ������ַ���
        return removeLine(str);
    }

    /**
     * ��Base64λ�����ͼƬ���н��룬�����浽ָ��Ŀ¼
     * 
     * @param base64
     *            base64�����ͼƬ��Ϣ
     * @return
     */
    public void decodeBase64ToFile(String base64, String path,String filename) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            FileOutputStream write = new FileOutputStream(new File(path
                    + filename));
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
}  