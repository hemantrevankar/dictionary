package com.springboot.exercise.Dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestClass2 {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		String[] units = s.nextLine().split(",");
		String[] equations = new String[units.length - 1];
		String[] equationLine[] = new String[equations.length][];

		for (int i=0; i<units.length-1; i++) {
			equations[i] = s.nextLine();
		}

		Map<String, String[]> mm = new HashMap<>();
		for (int j=0; j<equations.length; j++) {
			equationLine[j]=equations[j].split(" ");
			mm.put(equationLine[j][0], equationLine[j]);
		}
		
		Map<String, Integer> map = new HashMap<>();
		Set<String> leftUnits = new HashSet<>();
		for (String[] strarray : equationLine) {
			String _s = strarray[0];
			leftUnits.add(_s);
			if (!map.containsKey(_s)) {
				map.put(_s, 1);
			} else {
				map.put(_s, map.get(_s) + 1);
			}

			_s = strarray[3];
			if (!map.containsKey(_s)) {
				map.put(_s, 1);
			} else {
				map.put(_s, map.get(_s) + 1);
			}
		}
		
		String uniqueUnit = null;
		Set<String> uniqueUnits = new HashSet<>();
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				uniqueUnits.add(key);
			}
		}

		String mainUnit = null;
		for (String unit : uniqueUnits) {
			if (leftUnits.contains(unit)) {
				mainUnit = unit;
				break;
			}
		}
		
		StringBuilder finalString = new StringBuilder();
		finalString.append("1").append(mainUnit);
		String nextUnit = null;
		long time = 1;
		do {
			nextUnit = mm.get(mainUnit)[3];
			time *= Integer.parseInt(mm.get(mainUnit)[2]);
			finalString.append(" = ").append(time).append(mm.get(mainUnit)[3]);
			mainUnit = nextUnit;
		} while(mm.get(nextUnit) != null);
		System.out.println(finalString);
	}
}
