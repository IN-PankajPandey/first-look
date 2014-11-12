package com.pankaj.action;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
import java.math.BigDecimal;  
import java.math.MathContext;  
import java.util.ArrayList;  
  
import javax.imageio.ImageIO;  
  
/*** 
 *  
 *  
 * @author chenzheng_java 
 * @since 2011/7/29 
 *  
 */  
public class ImageHelper {  
  
    private static ImageHelper imageHelper = null;  
  
    public static ImageHelper getImageHelper() {  
        if (imageHelper == null) {  
            imageHelper = new ImageHelper();  
        }  
        return imageHelper;  
    }  
  
    /*** 
     *  
     *  
     * @param sourceImagePath 
     *             
     * @param destinationPath 
     *             
     * @param scale 
     *            ?1.2 
     */  
    public static void scaleImage(String sourceImagePath,  
            String destinationPath, double scale,String format) {  
  
        File file = new File(sourceImagePath);  
        BufferedImage bufferedImage;  
        try {  
            bufferedImage = ImageIO.read(file);  
            int width = bufferedImage.getWidth();  
            int height = bufferedImage.getHeight();  
  
            width = parseDoubleToInt(width * scale);  
            height = parseDoubleToInt(height * scale);  
  
            Image image = bufferedImage.getScaledInstance(width, height,  
                    Image.SCALE_SMOOTH);  
            BufferedImage outputImage = new BufferedImage(width, height,  
                    BufferedImage.TYPE_INT_RGB);  
            Graphics graphics = outputImage.getGraphics();  
            graphics.drawImage(image, 0, 0, null);  
            graphics.dispose();  
  
            ImageIO.write(outputImage, format, new File(destinationPath));  
        } catch (IOException e) {  
            System.out.println("scaleImage");  
            e.printStackTrace();  
        }  
  
    }  
  
    /*** 
     *  
     * @param sourceImagePath  
     * @param destinationPath  
     * @param width  
     * @param height  
     * @param auto  
     * @param format   jpg 
     */  
    public static void scaleImageWithParams(String sourceImagePath,  
            String destinationPath, int width, int height, boolean auto,String format) {  
          
        try {  
        File file = new File(sourceImagePath);  
        BufferedImage bufferedImage = null;  
        bufferedImage = ImageIO.read(file);  
            if (auto) {  
                ArrayList<Integer> paramsArrayList = getAutoWidthAndHeight(bufferedImage,width,height);  
                width = paramsArrayList.get(0);  
                height = paramsArrayList.get(1);  
                System.out.println("?width="+width+" height="+height);  
            }  
          
        Image image = bufferedImage.getScaledInstance(width, height,  
                Image.SCALE_DEFAULT);  
        BufferedImage outputImage = new BufferedImage(width, height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics graphics = outputImage.getGraphics();  
        graphics.drawImage(image, 0, 0, null);  
        graphics.dispose();  
        ImageIO.write(outputImage, format, new File(destinationPath));  
        } catch (Exception e) {  
            System.out.println("scaleImageWithParams");  
            e.printStackTrace();  
        }  
          
          
    }  
  
    /** 
     * doubleint? 
     *  
     * @param sourceDouble 
     * @return 
     */  
    private static int parseDoubleToInt(double sourceDouble) {  
        int result = 0;  
        result = (int) sourceDouble;  
        return result;  
    }  
      
    /*** 
     *  
     * @param bufferedImage  
     * @param width_scale  
     * @param height_scale  
     * @return ?? 
     */  
    private static ArrayList<Integer> getAutoWidthAndHeight(BufferedImage bufferedImage,int width_scale,int height_scale){  
        ArrayList<Integer> arrayList = new ArrayList<Integer>();  
        int width = bufferedImage.getWidth();  
        int height = bufferedImage.getHeight();  
        double scale_w =getDot2Decimal( width_scale,width);  
          
        System.out.println("getAutoWidthAndHeight width="+width + "scale_w="+scale_w);  
        double scale_h = getDot2Decimal(height_scale,height);  
        if (scale_w<scale_h) {  
            arrayList.add(parseDoubleToInt(scale_w*width));  
            arrayList.add(parseDoubleToInt(scale_w*height));  
        }  
        else {  
            arrayList.add(parseDoubleToInt(scale_h*width));  
            arrayList.add(parseDoubleToInt(scale_h*height));  
        }  
        return arrayList;  
          
    }  
      
      
    /*** 
     * a/b 
     * @param a 
     * @param b 
     * @return 
     */  
    public static double getDot2Decimal(int a,int b){  
          
        BigDecimal bigDecimal_1 = new BigDecimal(a);  
        BigDecimal bigDecimal_2 = new BigDecimal(b);  
        BigDecimal bigDecimal_result = bigDecimal_1.divide(bigDecimal_2,new MathContext(4));  
        Double double1 = new Double(bigDecimal_result.toString());  
        System.out.println("double?"+double1);  
        return double1;  
    }  
  
}  