package com.wwh.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @ClassName: DiskRelationInsertRuleUtils
 * @Description: c
 * @author: Administrator
 * @date: 2016年10月26日 下午4:39:27
 */
public class DiskRelationRuleUtils {

	private static Map<String, Map<String, List<Integer>>> map = new HashMap<>();

	static {
		map = fissionMap();
	}

	public static int orginal[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
			32, 33, 34, 35, 36, 37, 38, 39, 40 };

	public static List<Integer> orginalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
			24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40));
	public static List<Integer> insertList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 20, 15, 18, 21, 16, 19, 22, 23,
			26, 29, 24, 27, 30, 25, 28, 31, 32, 35, 38, 33, 36, 39, 34, 37, 40));

	public static int insert[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 20, 15, 18, 21, 16, 19, 22, 23, 26, 29, 24, 27, 30, 25, 28, 31,
			32, 35, 38, 33, 36, 39, 34, 37, 40 };

	public static List<Integer> fissionList = new ArrayList<>(
			Arrays.asList(-1, 1, 1, 1, 2, 3, 4, 2, 3, 4, 2, 3, 4, 5, 5, 5, 8, 8, 8, 11, 11, 11, 6, 6, 6, 9, 9, 9, 12, 12, 12, 7, 7, 7, 10, 10, 10, 13, 13, 13));

	// -1 表示出局总监
	public static int fission[] = new int[] { -1, 1, 1, 1, 2, 3, 4, 2, 3, 4, 2, 3, 4, 5, 5, 5, 8, 8, 8, 11, 11, 11, 6, 6, 6, 9, 9, 9, 12, 12, 12, 7, 7, 7, 10,
			10, 10, 13, 13, 13 };

	public static List<Integer> firstList = new LinkedList<>(Arrays.asList(2, 5, 6, 7, 14, 23, 32, 17, 26, 35, 20, 29, 38));
	public static List<Integer> secondList = new LinkedList<>(Arrays.asList(3, 8, 9, 10, 15, 24, 33, 18, 27, 36, 21, 30, 39));
	public static List<Integer> thirdList = new LinkedList<>(Arrays.asList(4, 11, 12, 13, 16, 25, 34, 19, 28, 37, 22, 31, 40));

	public static void printMap(String times) {
		Map<String, List<Integer>> map1 = map.get(times);
		// 遍历map中的键
		System.out.println("遍历map中的键  ");
		for (String key : map1.keySet()) {
			System.out.println("Key = " + key);
		}
		// 遍历map中的值
		System.out.println("遍历map中的值  ");
		for (List<Integer> value : map1.values()) {
			for (Integer integer : value) {
				System.out.print(integer + ",");

			}
		}
	}

	/**
	 * 
	 * @Title: fissionMap
	 * @Description: 分裂map
	 * @param orginalList
	 * @return
	 * @return: Map<String,Map<String,List<Integer>>>
	 */
	public static Map<String, Map<String, List<Integer>>> fissionMap() {

		Map<String, Map<String, List<Integer>>> map = new LinkedHashMap<String, Map<String, List<Integer>>>();

		Map<String, List<Integer>> map1 = new LinkedHashMap<String, List<Integer>>();
		List<Integer> DIRECTOR1 = new ArrayList<>();
		DIRECTOR1.add(2);
		map1.put("DIRECTOR1", DIRECTOR1);
		List<Integer> MANAGER1 = new ArrayList<>();
		MANAGER1.add(5);
		MANAGER1.add(6);
		MANAGER1.add(7);
		map1.put("MANAGER1", MANAGER1);
		List<Integer> PLAN1 = new ArrayList<>();
		PLAN1.add(14);
		PLAN1.add(23);
		PLAN1.add(32);
		PLAN1.add(17);
		PLAN1.add(26);
		PLAN1.add(35);
		PLAN1.add(20);
		PLAN1.add(29);
		PLAN1.add(38);
		map1.put("PLAN1", PLAN1);

		map.put("FIRST", map1);

		Map<String, List<Integer>> map2 = new LinkedHashMap<String, List<Integer>>();
		List<Integer> DIRECTOR2 = new ArrayList<>();
		DIRECTOR2.add(3);
		map2.put("DIRECTOR2", DIRECTOR2);
		List<Integer> MANAGER2 = new ArrayList<>();
		MANAGER2.add(8);
		MANAGER2.add(9);
		MANAGER2.add(10);
		map2.put("MANAGER2", MANAGER2);
		List<Integer> PLAN2 = new ArrayList<>();
		PLAN2.add(15);
		PLAN2.add(24);
		PLAN2.add(33);
		PLAN2.add(19);
		PLAN2.add(27);
		PLAN2.add(36);
		PLAN2.add(21);
		PLAN2.add(30);
		PLAN2.add(39);
		map2.put("PLAN2", PLAN2);

		map.put("SECOND", map2);

		Map<String, List<Integer>> map3 = new LinkedHashMap<String, List<Integer>>();
		List<Integer> DIRECTOR3 = new ArrayList<>();
		DIRECTOR3.add(4);
		map3.put("DIRECTOR3", DIRECTOR3);

		List<Integer> MANAGER3 = new ArrayList<>();
		MANAGER3.add(11);
		MANAGER3.add(12);
		MANAGER3.add(13);
		map3.put("MANAGER3", MANAGER3);
		List<Integer> PLAN3 = new ArrayList<>();
		PLAN3.add(16);
		PLAN3.add(25);
		PLAN3.add(34);
		PLAN3.add(19);
		PLAN3.add(28);
		PLAN3.add(27);
		PLAN3.add(22);
		PLAN3.add(31);
		PLAN3.add(40);
		map3.put("PLAN3", PLAN3);

		map.put("THIRD", map3);

		return map;
	}

	/**
	 * 
	 * @Title: getNewInsertLocation
	 * @Description: 得到新的插入下标
	 * @param orginal
	 *            当前盘人数
	 * @return
	 * @return: int
	 */
	public static Integer getNewInsertLocation(int orginal) {

		return insert[orginal];
	}

	public static List<Integer> profitList = new ArrayList<>(Arrays.asList(2, 5, 6, 7, 14, 23, 32, 17, 26, 35, 20, 29, 38));

	public static List<Integer> getUnderList(int location) {
		List<Integer> director = new LinkedList<>(
				Arrays.asList(14, 17, 20, 23, 26, 29, 32, 35, 38, 15, 18, 21, 24, 27, 30, 33, 36, 39, 16, 19, 22, 25, 28, 31, 34, 37, 40));
		List<Integer> manager2 = new LinkedList<>(Arrays.asList(14, 17, 20, 23, 26, 29, 32, 35, 38));
		List<Integer> manager3 = new LinkedList<>(Arrays.asList(15, 18, 21, 24, 27, 30, 33, 36, 39));
		List<Integer> manager4 = new LinkedList<>(Arrays.asList(16, 19, 22, 25, 28, 31, 34, 37, 40));
		List<Integer> planList5 = new LinkedList<>(Arrays.asList(14, 23, 32));
		List<Integer> planList6 = new LinkedList<>(Arrays.asList(17, 26, 35));
		List<Integer> planList7 = new LinkedList<>(Arrays.asList(20, 29, 38));
		List<Integer> planList8 = new LinkedList<>(Arrays.asList(15, 24, 33));
		List<Integer> planList9 = new LinkedList<>(Arrays.asList(18, 27, 36));
		List<Integer> planList10 = new LinkedList<>(Arrays.asList(21, 30, 39));
		List<Integer> planList11 = new LinkedList<>(Arrays.asList(16, 25, 34));
		List<Integer> planList12 = new LinkedList<>(Arrays.asList(19, 28, 37));
		List<Integer> planList13 = new LinkedList<>(Arrays.asList(22, 31, 40));
		switch (location) {
		case 1:
			return director;
		case 2:
			return manager2;
		case 3:
			return manager3;
		case 4:
			return manager4;
		case 5:
			return planList5;
		case 6:
			return planList6;
		case 7:
			return planList7;
		case 8:
			return planList8;
		case 9:
			return planList9;
		case 10:
			return planList10;
		case 11:
			return planList11;
		case 12:
			return planList12;
		case 13:
			return planList13;
		default:
			return null;
		}
	}
}
