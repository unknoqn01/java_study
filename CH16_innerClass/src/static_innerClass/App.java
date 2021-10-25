package static_innerClass;

public class App {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.print();
		//�̳�Ŭ���� (��ü�� ���鶧�� ���� �ܺ� Ŭ���� ��ü�� ����� ����� �ִ�)
		Person.Head head = p1.new Head();
		head.print();
		//스테틱 이너 클래스 외부객체에서 바로 .Body();
		Person.Body body = new Person.Body();
		body.print();
	}

}
