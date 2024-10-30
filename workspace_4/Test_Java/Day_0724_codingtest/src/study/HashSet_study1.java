package study;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet_study1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		HashSet sethap = new HashSet();
		setA.add("1");  setA.add("2"); setA.add("3");
		setA.add("4");  setA.add("5");
		System.out.println("A= "+setA);
		
		setB.add("4"); setB.add("5"); setB.add("6");
		setB.add("7"); setB.add("8");
		System.out.println("B= "+setB);
		
		Iterator it =setB.iterator();
		
		while (it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp))
				setKyo.add(tmp);
		}
		
		Iterator it1 = setA.iterator();
		
		while (it1.hasNext()) {
			Object tmp = it1.next();
			if(!(setB.contains(tmp)))
				setCha.add(tmp);
		}

		while (it1.hasNext()) {
			Object tmp = it1.next();
			sethap.add(tmp);
		}
		while (it.hasNext()) {
			Object tmp = it.next();
			sethap.add(tmp);
		}
	
		System.out.println(setKyo);
		System.out.println(sethap);
		System.out.println(setCha);
	}

}
