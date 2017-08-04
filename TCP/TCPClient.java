import java.io.*;
import java.net.*;

class TCPClient
{
  public static void main(String argv[]) throws Exception
  {
    String sentence;
    int l;
    int c1=0,c2=0,c3=0,i;
    String modifiedSentence;
    BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
    Socket clientSocket = new Socket("localhost", 6789);
    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    sentence = inFromUser.readLine();
    l=sentence.length();
    char ch;
    for(i=0;i<l;i++)
    {
      ch=sentence.charAt(i);
      if(Character.isLetter(ch))
      {
        c1=c1+1;
      }
      else if(Character.isDigit(ch))
      {
        c2=c2+1;
      }
      else
      {
        c3=c3+1;
      }
    }
    System.out.println("The no of letters is : "+c1+" Digits: "+c2+" Special : "+c3);
    outToServer.writeBytes(sentence + '\n');
    modifiedSentence = inFromServer.readLine();
    System.out.println("FROM SERVER: " + modifiedSentence);
    clientSocket.close();
  }
} 
