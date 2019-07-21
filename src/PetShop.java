class PetShop {
	private Pet[] pets;				// 保存多个属性
	private int foot;				// 数据的保存位置
	
	
	public PetShop(int len) {				// 构造方法开辟宠物数组的大小
		if(len>0){				// 判断长度是否大于0
			this.pets = new Pet[len];		// 为对象数组开辟空间
		}else{
			this.pets = new Pet[len] ;		// 至少开辟一个空间
		}
	}
	public boolean add(Pet pet) {			// 增加宠物
		if (foot < this.pets.length) {		// 判断宠物商店里的宠物是否已经满了
			this.pets[foot] = pet;		// 增加宠物
			foot++;				// 修改保存位置
			return true;			// 增加成功
		} else {					
			return false;			// 增加失败
		}
	}
	public Pet[] search(String keyWord){ 	// 关键字查找
		Pet p[] = null;			// 此为查找之后的结果，此处的大小不是固定的
		int count = 0;			// 记录下多少个宠物符合查询结果
		// 确认开辟的空间大小，看有多少个宠物符合查询条件
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {	//判断对象数组中的内容是否为空
				if (this.pets[i].getName().indexOf(keyWord) != -1
					|| this.pets[i].getColor().indexOf(keyWord) != -1) {
					count++;	// 统计符合条件的宠物个数
				}
			}
		}
		p = new Pet[count];			// 根据已经确定的记录数，开辟对象数组
		int f = 0;			// 设置增加的位置标记
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {
				if (this.pets[i].getName().indexOf(keyWord) != -1
					|| this.pets[i].getColor().indexOf(keyWord) != -1) {
					p[f] = this.pets[i]; // 将符合查询条件的宠物信息保存
					f++;
				}
			}
		}
		return p;
	}
};
