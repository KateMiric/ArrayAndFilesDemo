import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NetflixArray {
    private final int ARRAY_MAZ = 20000;
  NetflixShow[] showArray = new NetflixShow[ARRAY_MAZ];

  private int noOfItems = 0;

  public NetflixArray (String fileName){
     loadFile(fileName);
  }
public void loadFile(String fileName) {
    try {
        File netflixFile = new File(fileName);
        Scanner fileReader = new Scanner(netflixFile);
        while(fileReader.hasNextLine()) {
            String currLine = fileReader.nextLine();
            Scanner parser = new Scanner(currLine);
            parser.useDelimiter(";");
            String show = parser.next();
            int count = Integer.parseInt(parser.next());
            showArray[noOfItems] = new NetflixShow(show,count);
            noOfItems ++;
        }
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null,"error reading file");
    }
}// end load file

    public void saveFile(String fileName){
      try {
          File netflixFile = new File(fileName);
          FileWriter newFile = new FileWriter(netflixFile);
          for (int index = 0; index < noOfItems; index++) {
              newFile.write(showArray[index].forFile());
          }      // end for
          newFile.flush();
          newFile.close();
      } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"error writing file");
      }// end catch
    }

    public void fixTitles(){
      for (int index = 0 ; index < noOfItems; index++){
          showArray[index].cleanShowName();
      }
    }
}
