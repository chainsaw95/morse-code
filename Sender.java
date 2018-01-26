import java.io.*;
import sun.audio.*;
import java.util.Scanner;

class PlayBack {

  public void send() throws Exception {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String str = sc.nextLine();
    char charac[] = str.toCharArray();

    for (char a : charac) {

      if (Character.isSpace(a) || a == 'e' || a == 'E')
        continue;

      StringBuffer buff = new StringBuffer();
      buff.append("./Morse Code Wav/");
      buff.append(a);
      buff.append(".wav");

      
      InputStream in = new FileInputStream(buff.toString());
      // create an audiostream from the inputstream
      AudioStream audioStream = new AudioStream(in);
      // play the audio clip with the audioplayer class
      AudioPlayer.player.start(audioStream);

      buff.delete(0, buff.length());
      Thread.sleep(2000);

    }

  }

}

class Sender {
  public static void main(String[] args) throws Exception {
    PlayBack p1 = new PlayBack();
    p1.send();

  }
}