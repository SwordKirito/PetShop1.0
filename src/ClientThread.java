import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.ObjectOutputStream;
import java.io.PrintWriter;  
import java.net.Socket;  
import java.net.UnknownHostException;  
  
import javax.swing.JOptionPane;  
  
//启动客户端接收线程  
public class ClientThread {  
    public ClientThread(Socket s) throws UnknownHostException, IOException{    
        new Thread(new ReceiveClient(s)).start();  
    }  
}  
  
//客户端接收线程  
class ReceiveClient implements Runnable{  
    private Socket s;  
    public ReceiveClient(Socket s) {  
        this.s = s;  
    }  
    public void run() {  
        try {  
            //信息接收流  
            BufferedReader brIn = new BufferedReader(new InputStreamReader(s.getInputStream()));  
            while(true){      
                char info = (char)brIn.read();//读取信息流首字符，判断信息类型  
                String line = brIn.readLine();//读取信息流内容  
                if(info == '0'){//代表初始化表格  
                    
                }  
                if(info == '1'){//代表发送的是消息  
                    
                }  
                  
                if(info == '2' || info == '3'){//有新用户加入或退出，2为加入，3为退出  
                    String sub = line.substring(1, line.length()-1);  
                    String[] data = sub.split(",");  
                  //  WindowClient.user.clearSelection();  
                   // WindowClient.user.setListData(data);  
                }  
                  
                if(info == '4'){//4代表服务端退出  
                   // WindowClient.link.setText("连接");  
                  //  WindowClient.exit.setText("已退出");  
                   // WindowClient.socket.close();  
                   // WindowClient.socket = null;  
                    break;  
                }  
            }     
        } catch (IOException e) {  
          //  JOptionPane.showMessageDialog(WindowClient.window, "客户端已退出连接");  
        }  
    }     
}  
  
//客户端发送信息类  
class SendClient {  
    SendClient(ObjectOutputStream oos,Object message,String info) throws IOException{   
    	String messages = info + message;//添加信息头标记  
	    //    PrintWriter pwOut = null;  
	        
	    //    pwOut = new PrintWriter(socket.getOutputStream(),true);  
	    //    pwOut.println(messages);  
	        oos.writeObject(messages);
    }  
}     