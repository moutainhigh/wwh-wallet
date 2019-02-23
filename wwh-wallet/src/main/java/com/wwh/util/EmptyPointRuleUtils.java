package com.wwh.util;

/**
 * 
 * @ClassName: EmptyPointRuleUtils
 * @Description: 计算空点规则
 * @author: lilinxiang
 * @date: 2016年11月14日 上午7:35:44
 */
public class EmptyPointRuleUtils {

	/**
	 * 
	 * @Title: calcEmpty
	 * @Description: 计算我得到点数, 除以2 后的数 , 非空点数
	 * @param point
	 * @return
	 * @return: int
	 */
	public static int calcGetNotEmptyPointForSelf(int point) {

		if (point > CommonConstant.ENOUGH_POINT_NUM) {
			return 0;
		}

		return point / 2;

	}

	/**
	 * 
	 * @Title: calcGetEmpty
	 * @Description: 计算我的空点数, 除以2 后的数
	 * @param point
	 * @return
	 * @return: int
	 */
	public static int calcEmptyForSelf(int point) {

		if (point > CommonConstant.ENOUGH_POINT_NUM) {
			return CommonConstant.TOTAL_POINT_PHR - 0;
		}

		return CommonConstant.TOTAL_POINT_PHR - point / 2;

	}

	/**
	 * 
	 * @Title: useGetPoint
	 * @Description: 得到剩余的点数 ,抢点后 剩余的点数, 用于 B 点 出局总监的抢点关系表
	 * @param point
	 * @return
	 * @return: int
	 */
	public static int getGrapPointRemainsPoint(int point) {
		int po = 0;

		int origin = point / 2;

		if (origin >= 3) {

			int v1 = origin - 3;

			if (point % 2 == 0) {
				po = v1 * 2;
			} else {
				po = v1 * 2 + 1;
			}
		} else {
			po = 0;
		}
		return po;
	}

	/**
	 * 
	 * @Title: remainGrapPointRemainsPoint 
	 * @Description: 不满足6 抢点后剩余点数
	 * @param point
	 * @return
	 * @return: int
	 */
	public static int remainXiaoyu6(int point) {
		int po = 0;

		int origin = point / 2;

//		if (origin >= 3) {

			int v1 =  3-origin ;

			if (point % 2 == 0) {
				po = v1 * 2;
			} else {
				po = point-origin;
			}
//		} else {
//			po = 0;
//		}
		return po;
	}
	
	
	public static void main(String[] args) {
		
//		int emptyPoint = EmptyPointRuleUtils.calcEmptyForSelf(myPoint);
//		int getPoint = EmptyPointRuleUtils.calcGetNotEmptyPointForSelf(myPoint);
		
		System.out.println(calcEmptyForSelf(5));
		
//		System.out.println(calcGetNotEmptyPointForSelf(6));
//		System.out.println(getGrapPointRemainsPoint(6));
//		System.out.println(remainXiaoyu6(5));
	}
}
