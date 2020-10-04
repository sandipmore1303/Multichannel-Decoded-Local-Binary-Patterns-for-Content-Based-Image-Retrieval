import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class ShowImage extends Panel {
    BufferedImage  image;
	String imageName;

  public ShowImage(String in) {
    try {
  //System.out.println("Enter image name\n");
  //BufferedReader bf=new BufferedReader(new 
  //InputStreamReader(System.in));
   String imageName=in;
  File input = new File(imageName);
      image = ImageIO.read(input);
    } catch (IOException ie) {
      System.out.println("Error:"+ie.getMessage()+imageName);
    }
  }
public ShowImage(BufferedImage br)
{
  image =br; 
}
  public void paint(Graphics g) {
    g.drawImage( image, 0, 0, null);
  }

   
}