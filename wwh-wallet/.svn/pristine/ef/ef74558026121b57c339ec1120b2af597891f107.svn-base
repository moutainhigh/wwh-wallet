package com.wwh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;

/**
 * 文件常量处理类
 * @author lyj 2016年1月14日
 *
 */
public class FileUtil {

	/**
	 * 盘点多少分钟前生成的文件是否存在
	 * @param fileName 文件名
	 * @param minute 多少分钟前
	 * @return
	 */
	public static boolean exitFileByMinuteBefore(String fileName, int minute) throws Exception{
		boolean result = false;
		File f = new File(fileName);
		//文件不存在直接返回false
		if(!f.exists()){
			return false;
		}
		Calendar cal = Calendar.getInstance();
		long time = f.lastModified();
		cal.setTimeInMillis(time);
		cal.add(Calendar.MINUTE, minute);
		Date fileCreateTimeAf = cal.getTime();
		Date nowTime = new Date();
		if (nowTime.after(fileCreateTimeAf)){
			result = false;
		}else{
			result = true;
		}
		return result;
	}
	
//	/**
//	 * 创建或者修改文件
//	 * @param fileName 文件名称
//	 * @param content 写入文件数据
//	 * @return
//	 * @throws IOException 
//	 */
//	public static void writeFile(String fileName, String content) throws IOException{
//		FileOutputStream o = null;
//		try {
//			File f = new File(fileName);
//			//判断文件是否存在,不存在则创建一个
//			if (!f.exists()){
//				File fp = new File(PropertyConstant.FILE_SAVE_PATH);
//				if(!fp.exists()  && !fp.isDirectory()){
//					fp.mkdirs();
//				}
//				f.createNewFile();
//			}
//			o = new FileOutputStream(fileName);
//			o.write(content.getBytes("UTF-8"));  
//		    o.close();  
//		} catch (Exception e) {
//			throw new IOException();
//		}finally{
//			if(null != o){
//				o.close();
//			}
//		}
//	}
	
	/**
	 * 读取文件内容
	 * @param fileName 文件名称
	 * @return
	 */
	public static String readFile(String fileName) throws IOException{
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
        	File file = new File(fileName);
        	// 将文件读入输入流
        	inputStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        	throw new IOException();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                	throw new IOException();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                	throw new IOException();
                }
            }
        }
        return sb.toString();
	}
	
	
	public static void main(String[] args) {
		
	}
/*	public static void main(String[] args) {
//		try {
//			System.out.println(exitFileByMinuteBefore("F:\\电量111.txt",5));
//			System.out.println(readFile("F:\\电量111.txt"));
//			String content = "";
//			List<MsgInfoModel> list = new ArrayList<MsgInfoModel>();
//			for (int i = 0; i < 5; i++) {
//				MsgInfoModel model = new MsgInfoModel();
//				model.setId(i);
//				model.setCreateDate("2015-11-11");
//				model.setDescript("中国");
//				list.add(model);
//			}
//			content = JSONArray.fromObject(list).toString();
//			writeFile("F:\\电量111.txt",content);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}*/
}
