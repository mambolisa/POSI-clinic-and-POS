/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formtemplates.QrCode;

/**
 *
 * @author Aquarius
 */
import java.io.File;
import java.io.FileOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

/**
 *
 * @author Kaesar ALNIJRES
 *
 */
public class HelloWorld {

  //Bar code generation
    public static void main(String[] args) {
      
           int width = 440;
           int height = 48;
           
             
           BitMatrix bitMatrix;
        try {
            bitMatrix = new Code128Writer().encode("Hello World !!!",BarcodeFormat.CODE_128,width,height,null);
            MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new File("C:\\Users\\Aquarius\\Desktop\\Qr\\zxing_barcode.png")));
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
