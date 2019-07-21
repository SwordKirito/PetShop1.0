class PetShop {
	private Pet[] pets;				// ����������
	private int foot;				// ���ݵı���λ��
	
	
	public PetShop(int len) {				// ���췽�����ٳ�������Ĵ�С
		if(len>0){				// �жϳ����Ƿ����0
			this.pets = new Pet[len];		// Ϊ�������鿪�ٿռ�
		}else{
			this.pets = new Pet[len] ;		// ���ٿ���һ���ռ�
		}
	}
	public boolean add(Pet pet) {			// ���ӳ���
		if (foot < this.pets.length) {		// �жϳ����̵���ĳ����Ƿ��Ѿ�����
			this.pets[foot] = pet;		// ���ӳ���
			foot++;				// �޸ı���λ��
			return true;			// ���ӳɹ�
		} else {					
			return false;			// ����ʧ��
		}
	}
	public Pet[] search(String keyWord){ 	// �ؼ��ֲ���
		Pet p[] = null;			// ��Ϊ����֮��Ľ�����˴��Ĵ�С���ǹ̶���
		int count = 0;			// ��¼�¶��ٸ�������ϲ�ѯ���
		// ȷ�Ͽ��ٵĿռ��С�����ж��ٸ�������ϲ�ѯ����
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {	//�ж϶��������е������Ƿ�Ϊ��
				if (this.pets[i].getName().indexOf(keyWord) != -1
					|| this.pets[i].getColor().indexOf(keyWord) != -1) {
					count++;	// ͳ�Ʒ��������ĳ������
				}
			}
		}
		p = new Pet[count];			// �����Ѿ�ȷ���ļ�¼�������ٶ�������
		int f = 0;			// �������ӵ�λ�ñ��
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {
				if (this.pets[i].getName().indexOf(keyWord) != -1
					|| this.pets[i].getColor().indexOf(keyWord) != -1) {
					p[f] = this.pets[i]; // �����ϲ�ѯ�����ĳ�����Ϣ����
					f++;
				}
			}
		}
		return p;
	}
};
