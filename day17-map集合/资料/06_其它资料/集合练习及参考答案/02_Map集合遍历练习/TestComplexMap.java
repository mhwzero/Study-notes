package com.itheima.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.itheima.domain.Student;

/**
 * //˼����:��һ��String�������ѧ�����Ʊ���"javaѧ��",�ڶ���String����:����İ༶����"JavaEE0320" ,ArrayList����ð༶���ѧ��
		HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>> hs =
					new HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>>();
 * @author JX
 *
 */
public class TestComplexMap {
	public static void main(String[] args) {
		HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>> hs =
				new HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>>();
		ArrayList<Student> ls1 = new ArrayList<Student>();
		ls1.add(new Student("����",30));
		ls1.add(new Student("����2",29));
		ls1.add(new Student("����3",33));
		ArrayList<Student> ls2 = new ArrayList<Student>();
		ls2.add(new Student("����",31));
		ls2.add(new Student("����2",22));
		ls2.add(new Student("����3",35));
		ArrayList<Student> ls3 = new ArrayList<Student>();
		ls3.add(new Student("����",40));
		ls3.add(new Student("����2",49));
		ls3.add(new Student("����3",43));
		HashMap<String,ArrayList<Student>> java0320 = new HashMap<>();
		java0320.put("javaEE0320", ls1);
		HashMap<String,ArrayList<Student>> java0410 = new HashMap<>();
		java0410.put("javaEE0410", ls2);
		HashMap<String,ArrayList<Student>> java0318 = new HashMap<>();
		java0318.put("Android0318", ls3);
		ArrayList<HashMap<String,ArrayList<Student>>> javaList = new ArrayList<HashMap<String,ArrayList<Student>>>();
		javaList.add(java0320);
		javaList.add(java0410);
		javaList.add(java0318);
		hs.put("javaѧ��", javaList);
		
		//����HashMap
		//HashMap<String,ArrayList<HashMap<String,ArrayList<Student>>>> hs
		//������ʽ��:�õ�����
		
		Set<String> set = hs.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String xueke = it.next();
			System.out.println(xueke+" �����°༶: ");
			ArrayList<HashMap<String,ArrayList<Student>>> list = hs.get(xueke);
			Iterator<HashMap<String,ArrayList<Student>>> subIt = list.iterator();
			while(subIt.hasNext()) {
				HashMap<String,ArrayList<Student>> subHs = subIt.next();
				Set<String> subSet = subHs.keySet();
				Iterator<String> subSubIt = subSet.iterator();
				while(subSubIt.hasNext()) {
					String className = subSubIt.next();
					System.out.println(className+" �༶������ѧԱ: ");
					ArrayList<Student> subList = subHs.get(className);
					Iterator<Student> subSubSubIt = subList.iterator();
					while(subSubSubIt.hasNext()) {
						Student student = subSubSubIt.next();
						System.out.print(student+" ");
					}
					System.out.println();
				}
			}
		}
		
		
		
		
		
		/*//������ʽһ:�ø߼�for
		for(Entry<String,ArrayList<HashMap<String,ArrayList<Student>>>> entry : hs.entrySet()) {
			
			String xueke = entry.getKey();
			
			System.out.println(xueke+" �����°༶: ");
			
			for(HashMap<String,ArrayList<Student>> hm : entry.getValue()) {
				
				for(Entry<String,ArrayList<Student>> subEntry : hm.entrySet()) {
					
					String className = subEntry.getKey();
					
					System.out.println(className+" �༶������ѧԱ: ");
					
					for(Student student : subEntry.getValue()) {
						
						System.out.println(student);
					}
				}
			}
			
		}*/
	}
}