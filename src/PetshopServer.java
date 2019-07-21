import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class PetshopServer {
	Socket client= null;
	DBoperator dBoperator=new DBoperator();
	
	private static int port = 8888;	
	public static void main(String[] args) {
		System.out.println("服务器启动");
		PetshopServer petshopServer = new PetshopServer();
		petshopServer.init();
	}
	
	public void init() {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			while(true){
				client = serverSocket.accept();
				new HandlerThread(client);    
			}
		} catch (IOException e) {
			System.out.println("服务器异常"+e.getMessage());
		}
		
	}
	
	private class HandlerThread implements Runnable{
		private Socket socket;
		public HandlerThread(Socket client) {
			socket=client;
			new Thread (this).start();
		}
		
		public void run(){
			try {  
	            //读取信息流  
	            BufferedReader brIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
	            while(true){          
	            	ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
	                char info = (char)brIn.read();//先读取信息流的首字符，并判断信息类型  
	                String line = brIn.readLine();//读取信息流的信息内容  
	                
	                if(info=='0'){//0代表初始化table
	                	List<Pet> listPets=dBoperator.listPet(null);
	                	for(int i=0;i<listPets.size();i++){
	                		new SendServer(oos,listPets.get(i), "0");//将列表发给客户端  
	                		
	                	}
	                	
	                }
	                 /* 
	                if(info == '1'){//1代表收到添加信息  
	                    WindowServer.textMessage.append(line + "\r\n");//将信息添加到服务端聊天记录中  
	                    //设置消息显示最新一行，也就是滚动条出现在末尾，显示最新一条输入的信息  
	                    WindowServer.textMessage.setCaretPosition(WindowServer.textMessage.getText().length());  
	                    new SendServer(userList, line, "1");//将信息转发给客户端  
	                }  
	                  
	                if(info == '2'){//2代表有新客户端建立连接  
	                    userName.add(line);//将新客户端用户名添加到容器中  
	                    WindowServer.user.setListData(userName);//更新服务端用户列表  
	                    new SendServer(userList, userName, "2");//将用户列表以字符串的形式发给客户端  
	                }  
	                  
	                if(info == '3'){//3代表有用户端退出连接  
	                    userName.remove(line);//移除容器中已退出的客户端用户名  
	                    userList.remove(socket);//移除容器中已退出的客户端的socket  
	                    WindowServer.user.setListData(userName);//更新服务端用户列表  
	                    new SendServer(userList, userName, "3");//将用户列表以字符串的形式发给客户端  
	                    socket.close();//关闭该客户端的socket  
	                    break;//结束该客户端对于的信息接收线程  
	                }  */
	            }     
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    }    
			
			
	}
	class SendServer {  
	    SendServer(ObjectOutputStream oos,Object message,String info) throws IOException{  
	        String messages = info + message;//添加信息头标记  
	    //    PrintWriter pwOut = null;  
	        
	    //    pwOut = new PrintWriter(socket.getOutputStream(),true);  
	    //    pwOut.println(messages);  
	        oos.writeObject(messages);
	    }  
	}   	
	
}
