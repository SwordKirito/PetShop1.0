import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DBoperator {
	
	static public File file;
	
	public String path = new String("E:\\程序试做\\java课\\PetShop1.0\\Database\\Pet\\");
	
	
	
	
	/**
	 * 存在宠物类别
	 * @param type
	 * @return
	 */
	public boolean ExistPetType(String type) {
		file =new File(path);
		String strlist[]=file.list();
		int key=0;
		for(int i=0;i<strlist.length;i++){
			if(strlist[i].equals(type)){
				key++;
				System.out.println("已经存在 "+type +" 类！！");
				return true;
			}
		}
		System.out.println("不存在 "+type +" 类，可以进行创建！！");
		return false;
	}
	/**
	 * 存在宠物
	 * @param type
	 * @return
	 */
	public boolean ExistPet(String type,String name) {
		file =new File(path+type);
		String strlist[]=file.list();
		int key=0;
		for(int i=0;i<strlist.length;i++){
			if(strlist[i].equals(name)){
				key++;
				System.out.println("已经存在 "+type +" 类下的名为 "+name+" 的宠物！！");
				return true;
			}
		}
		System.out.println("不存在 "+type +" 类下的名为 "+name+" 的宠物，可以进行添加！！");
		return false;
	}
	/**
	 * 添加宠物类别
	 * @param type
	 * @throws IOException
	 */
	public void AddPetType(String type) throws IOException {
		if(!ExistPetType(type)){
			file =new File(path+type);
			file.mkdir();
		}
	}
	
	/**
	 * 添加宠物
	 * 
	 * 返回1添加成功
	 * 返回0添加失败
	 * @param type
	 * @param name
	 * @param age
	 * @param color
	 * @throws IOException
	 */
	public int AddPet(String type,String name,String age,String color) throws IOException{
		file=new File(path+type+file.separator+name);
		if(!file.exists()){
			Pet newPet = new Pet(name, age, color);
			file = new File(path+type+File.separator+name);
			file.createNewFile();
			ObjectOutputStream oos = null;
			OutputStream out = new FileOutputStream(file);	// 文件输出流
			oos = new ObjectOutputStream(out); 		// 为对象输出流实例化
			oos.writeObject(newPet);		// 保存对象到文件
			oos.close(); 	
			return 1;
		}
		else{
			System.out.println("已经存在 "+type +" 类下的名为 "+name+" 的宠物，无法进行添加！！");
			return 0;
		}
	}
	/**
	 * 删除宠物
	 * 返回1删除成功
	 * 返回0删除失败
	 * @param name
	 */
	public int DeletePet(String type,String name){
		file = new File(path+type+File.separator+name);
		if(file.exists()){
			System.out.println("存在 "+name+" 宠物，可以进行删除");
			file.delete();
			return 1;
		}else{
			System.out.println("不存在 "+type +" 类下的名为 "+name+" 的宠物，无法进行删除！！");
			return 0;
		}
	}
	
	/**
	 * 修改宠物
	 * 
	 * 返回1修改成功
	 * 返回0修改失败
	 * @param args
	 * @throws IOException
	 */
	public int UpdatePet(String type,String name,String name2,String age2,String color2) throws IOException{
		
		Pet newPet=new Pet(name2, age2, color2) ;

		file = new File(path+type+File.separator+name);
		if(file.exists()){
			System.out.println("存在 "+name+" 宠物，可以进行修改");
			//修改操作
			ObjectOutputStream oos = null;
			OutputStream out = new FileOutputStream(file);	// 文件输出流
			oos = new ObjectOutputStream(out); 		// 为对象输出流实例化
			oos.writeObject(newPet);		// 保存对象到文件
			oos.close(); 	
			if(!name.equals(name2)){
				file.renameTo(new File(path+type+File.separator+name2));
			}
			return 1;
		}else{
			System.out.println("不存在 "+type +" 类下的名为 "+name+" 的宠物，无法进行修改！！");
			return 0;
		}
	}
	
	public Pet getPet(String type,String name) throws IOException, ClassNotFoundException{
		
		file = new File(path+type+File.separator+name);
		if(file.exists()){
			System.out.println("存在 "+name+" 宠物，可以进行修改");
			//对象反序列化操作
			ObjectInputStream ois = null;
			InputStream input = new FileInputStream(file);	// 文件输入流
			ois = new ObjectInputStream(input); 		// 为对象输出流实例化
			Object obj = ois.readObject(); 			// 读取对象
			ois.close();		
			return (Pet)obj;
		}else{
			System.out.println("不存在 "+type +" 类下的名为 "+name+" 的宠物，无法进行修改！！");
			return new Pet(null, null, null);
		}
	}
	
	public Pet SearchPet(String name) throws IOException, ClassNotFoundException{
		file=new File(path);
		if (file != null) {			// 增加一个检查机制
			File f[] = file.listFiles() ;// 如果是目录，则列出全部内容
			if (f != null) {		// 有可能无法列出目录中的文件 
				
				for (int i = 0; i < f.length; i++) {
					File namelist[]=f[i].listFiles();
					if(namelist!=null){
						for(int j=0;j<namelist.length;j++){
							//System.out.println(namelist[j].toString());
							if(namelist[j].toString().contains(name)){
								//对象反序列化操作
								ObjectInputStream ois = null;
								InputStream input =new FileInputStream(new File(namelist[j].toString())) ;	// 文件输入流
								ois = new ObjectInputStream(input); 		// 为对象输出流实例化
								Object obj = ois.readObject(); 			// 读取对象
								ois.close();	
								return (Pet)obj;
								
							}
							
						}
					}
				}
			}
		}
		System.out.println("没有此宠物");
		return null;
	}
	
	public List<Pet> listPet(String type) throws Exception{
		List<Pet> rs=new ArrayList<Pet>();
		if(type==null){
			file=new File(path);
			if (file != null) {			// 增加一个检查机制
				File f[] = file.listFiles() ;// 如果是目录，则列出全部内容
				if (f != null) {		// 有可能无法列出目录中的文件 
					
					for (int i = 0; i < f.length; i++) {
						File name[]=f[i].listFiles();
						if(name!=null){
							for(int j=0;j<name.length;j++){
								
								
								//对象反序列化操作
								ObjectInputStream ois = null;
								InputStream input =new FileInputStream(new File(name[j].toString())) ;	// 文件输入流
								ois = new ObjectInputStream(input); 		// 为对象输出流实例化
								Object obj = ois.readObject(); 			// 读取对象
								ois.close();	
								
								rs.add((Pet)obj);
							}
						}
					}
				}
			}
		}else if(ExistPetType(type)){
			file=new File(path+type+File.separator);
			if (file != null) {			// 增加一个检查机制
				File name[] = file.listFiles() ;// 如果是目录，则列出全部内容
				if (name != null) {		// 有可能无法列出目录中的文件 
					for(int j=0;j<name.length;j++){
						
						//对象反序列化操作
						ObjectInputStream ois = null;
						InputStream input = new FileInputStream(new File(name[j].toString()));	// 文件输入流
						ois = new ObjectInputStream(input); 		// 为对象输出流实例化
						Object obj = ois.readObject(); 			// 读取对象
						ois.close();	
						rs.add((Pet)obj);
					}
				}
			}
		}
		
		return rs;
	}
	
	
	public static void main(String[] args) throws Exception {
		String type=new String("海星");
		String name=new String("宝石海星");
		String age=new String("2");
		String color=new String("棕色");

		//String name2=new String("欢欢");
		//String age2=new String("2");
		//String color2=new String("黄色");
		//new DBoperator().AddPetType(type);
	   	//new DBoperator().AddPet(type, name, age, color);
		//System.out.println(new DBoperator().listPet(null));
		//new DBoperator().UpdatePet(type, name, name2, age2, color2);
		//new DBoperator().DeletePet(type, name);
		List<Pet>pets=new DBoperator().listPet(null);
		for(int i=0;i<pets.size();i++){
			System.out.println("123"+pets.get(i));
		}
		new DBoperator().SearchPet("小小鳄");
	}
}
