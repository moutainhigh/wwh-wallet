package com.wwh.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wwh.vo.DefinedProfitConfigVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ToolsUtil {
	/**
	 * 获取配置文件中的json字符串
	 */
	private static String profitConfigJson() {

		String profitConfigJson = "";
		try {
			ClassLoader classLoader = ToolsUtil.class.getClassLoader();
			URL resource = classLoader.getResource("profit_config.txt");
			String path = resource.getPath();
			String fileName = path;
			profitConfigJson = FileUtil.readFile(fileName);
		} catch (IOException e) {
			profitConfigJson = "";
		}
		return profitConfigJson;
	}

	/**
	 * 
	 * @Title: getProfitConfigFromJson
	 * @Description: 传入位置，找出相应的建立人，顺序 [0]规划师 [1]经理 [2] 总监
	 * @param location
	 * @return
	 * @return: List<DefinedProfitConfigVO>
	 */
	public static List<DefinedProfitConfigVO> getProfitConfigFromJson(Integer location) {
		List<DefinedProfitConfigVO> definedProfitConfigVOs = new ArrayList<DefinedProfitConfigVO>();

		JSONArray array = JSONArray.fromObject(profitConfigJson());

		for (int i = 0; i < array.size(); i++) {
			JSONObject rs = (JSONObject) array.get(i);
			DefinedProfitConfigVO aobj = (DefinedProfitConfigVO) JSONObject.toBean(rs, DefinedProfitConfigVO.class);

			int a = location;
			int b = aobj.getRechargeMan();

			if (a == b) {
				List<String> profitManList = new ArrayList<>();
				profitManList = new ArrayList<>(Arrays.asList(aobj.getProfitMan().split(",")));

				aobj.setProfitManList(profitManList);
				definedProfitConfigVOs.add(aobj);

				break;
			}

		}

		return definedProfitConfigVOs;
	}

	/**
	 * 
	 * @Title: getProfitConfigFromJson
	 * @Description: 读取建立配置
	 * @return
	 * @return: List<DefinedProfitConfigVO>
	 */
	public static List<DefinedProfitConfigVO> getProfitConfigFromJson() {
		List<DefinedProfitConfigVO> definedProfitConfigVOs = new ArrayList<DefinedProfitConfigVO>();

		JSONArray array = JSONArray.fromObject(profitConfigJson());

		for (int i = 0; i < array.size(); i++) {
			JSONObject rs = (JSONObject) array.get(i);
			DefinedProfitConfigVO aobj = (DefinedProfitConfigVO) JSONObject.toBean(rs, DefinedProfitConfigVO.class);

			List<String> profitManList = new ArrayList<>();
			profitManList = new ArrayList<>(Arrays.asList(aobj.getProfitMan().split(",")));

			aobj.setProfitManList(profitManList);
			definedProfitConfigVOs.add(aobj);
		}

		return definedProfitConfigVOs;
	}
}
