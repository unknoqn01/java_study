package static_innerClass;

public class Person {
	class Head {
		public void print() { //���� Ŭ���� Head
			System.out.println("���");
		}
	}

	static class Body { //������ ���� Ŭ���� Body
		public void print() {
			System.out.println("�ٵ�");
		}
	}
	public void print() { //Ŭ���� Person�� �޼ҵ�
		Head head = new Head(); //��� ��ü
		Body body = new Body(); //body 객체
		
		head.print();
		body.print();
	}
}
