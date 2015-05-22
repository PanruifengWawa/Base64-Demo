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
 * 使用base64编码方式对文件和字符串进行编码解码 
 */  
public class Base64UTIL {  
	private String removeLine(String str){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		String dest = m.replaceAll("");
		return dest;
	}
  
	public String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
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
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        
        String str =  encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
        return removeLine(str);
    }

    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     * 
     * @param base64
     *            base64编码的图片信息
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