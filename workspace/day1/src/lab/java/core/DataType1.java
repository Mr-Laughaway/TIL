package lab.java.core;

public class DataType1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�޸𸮴� 1byte �Ҵ�
		boolean success = false; //������ ȣȯ �Ұ�, Ű���� false �Ǵ� true�� ���� ����
		System.out.println(success);
//		success = 1;
		
		//byte �����ڷ���, 1byte �Ҵ�, sign bit, binary, -2^7 ~ 2^7-1 (-128 ~ 127)
		byte num1 = 127;
		System.out.println(num1);
//		num1 = 128;

		//short �����ڷ���, 2byte �Ҵ�, sign bit, binary, -2^15 ~ 2^15-1, -32768~32767
		short num2 = 32767;
		System.out.println(num2);
//		num2 = 32768;
		
		//int �����ڷ���, 4byte �Ҵ�, -2^31 ~ 2^31-1, -2147483648~2147483647
		int num3 = 2147483647;
		System.out.println(num3);
//		num3 = 2147483648;
		num3 = 077; //8����
		System.out.println(num3); //����� decimal 10������
		num3 = 0xff; //16����
		System.out.println(num3); //����� decimal 10������
		
		//long �����ڷ���, -2^63 ~ 2^63-1
		long num4 = 2147483648L;
		System.out.println(num4); //����� decimal 10������
		
		//char ���� �ڷ��� �ڹٴ� unicode����, 2byte�Ҵ�, 0~2^16-1,
		char ch1 = 'A';
		System.out.println(ch1);
		ch1 = 97; //ASCII �ڵ尪
		System.out.println(ch1);
		ch1 = '\u0063'; //unicode �ڵ尪
		System.out.println(ch1);
		
		//�Ǽ� �ڷ���, �ε��Ҽ��� ����(������, ������), 4�Ҵ�
		float num5 = 3.14f; //default �Ǽ� literal�� double�̴� �׷��� float���� f�� �ٿ���...
		System.out.println(num5);
		double num6 = 3.14;
		System.out.println(num6);
		num6 = 1.20437E-5; //IEEE ǥ������, ������ ��ġ ǥ������
		System.out.println(num6);
		num6 = 1.20437E+9;
		System.out.println(num6);
		
		//�U�ڿ��� Reference Data Type(��ü)
		String st = new String("java"); //st�� ��ü��, heap�޸𸮿� ��ü ����
		System.out.println(st);
		System.out.println(st.length());
		
		String st2 = "java"; //String ��� pool �޸� ������ ����
		System.out.println(st2);
		
		final int PORT = 9000; //���
		System.out.println(PORT);
//		PORT = 5555;
		
	}

	
}
