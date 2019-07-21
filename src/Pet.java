import java.io.File;
import java.io.Serializable;

public class Pet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3012355433025243218L;


	static public String path = new String("E:\\程序试做\\java课\\PetShop1.0\\Database\\Pet\\");
	private String name;		
	private String age;
	private String color;	
	

	/**
	 * @param name
	 */
	public Pet(String name) {
		super();
		this.name = name;
	}


	/**
	 * @param name
	 * @param age
	 * @param color
	 */
	
	public String getType(){
		String petType[]=new File(path).list();
		for(int i=0;i<petType.length;i++){
			String petNames[]=new File(path+petType[i]+File.separator).list();
			for(int j=0;j<petNames.length;j++){
				if(petNames[j].equals(this.name)){
					return petType[i];
				}
			}
		}
		return null;
	}
	
	
	public Pet(String name, String age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String toString() {
		return "姓名："+name+"\t年龄："+age+"\t颜色："+color+"\n";
	}	

}
