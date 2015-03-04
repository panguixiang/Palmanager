package com.afmobi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class CountryTable {
	static Connection conn = null;
	static {
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://172.17.2.83:3306/palmplay_item?user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}// 动态加载mysql驱动
	}
	public static void main(String[] args) {
		String countryStr = "[{\"countryNameCN\":\"尼日利亚\",\"countryCode\":\"NG\",\"countryNameEN\":\"Nigeria\"},{\"countryNameCN\":\"肯尼亚\",\"countryCode\":\"KE\",\"countryNameEN\":\"Kenya\"},{\"countryNameCN\":\"埃塞俄比亚\",\"countryCode\":\"ET\",\"countryNameEN\":\"Ethiopia\"},{\"countryNameCN\":\"坦桑尼亚\",\"countryCode\":\"TZ\",\"countryNameEN\":\"Tanzania\"},{\"countryNameCN\":\"乌干达\",\"countryCode\":\"UG\",\"countryNameEN\":\"Uganda\"},{\"countryNameCN\":\"喀麦隆\",\"countryCode\":\"CM\",\"countryNameEN\":\"Cameroon\"},{\"countryNameCN\":\"中国\",\"countryCode\":\"CN\",\"countryNameEN\":\"China\"},{\"countryNameCN\":\"法国\",\"countryCode\":\"FR\",\"countryNameEN\":\"France\"},{\"countryNameCN\":\"西班牙\",\"countryCode\":\"ES\",\"countryNameEN\":\"Spain\"},{\"countryNameCN\":\"葡萄牙\",\"countryCode\":\"PT\",\"countryNameEN\":\"Portugal\"},{\"countryNameCN\":\"阿尔及利亚\",\"countryCode\":\"DZ\",\"countryNameEN\":\"Algeria\"},{\"countryNameCN\":\"安哥拉\",\"countryCode\":\"AO\",\"countryNameEN\":\"Angola\"},{\"countryNameCN\":\"巴林\",\"countryCode\":\"BH\",\"countryNameEN\":\"Bahrain\"},{\"countryNameCN\":\"不丹\",\"countryCode\":\"BT\",\"countryNameEN\":\"Bhutan\"},{\"countryNameCN\":\"中非共和国\",\"countryCode\":\"CF\",\"countryNameEN\":\"Central African Rep.\"},{\"countryNameCN\":\"乍得\",\"countryCode\":\"TD\",\"countryNameEN\":\"Chad\"},{\"countryNameCN\":\"刚果\",\"countryCode\":\"CG\",\"countryNameEN\":\"Congo\"},{\"countryNameCN\":\"刚果民主共和国\",\"countryCode\":\"CD\",\"countryNameEN\":\"Congo Democratic Rep.\"},{\"countryNameCN\":\"哥斯达黎加\",\"countryCode\":\"CR\",\"countryNameEN\":\"Costa Rica\"},{\"countryNameCN\":\"科特迪瓦\",\"countryCode\":\"CI\",\"countryNameEN\":\"Cote D'lvoire\"},{\"countryNameCN\":\"多米尼加\",\"countryCode\":\"DM\",\"countryNameEN\":\"Dominica\"},{\"countryNameCN\":\"多米尼加共和国\",\"countryCode\":\"DO\",\"countryNameEN\":\"Dominican Rep.\"},{\"countryNameCN\":\"埃及\",\"countryCode\":\"EG\",\"countryNameEN\":\"Egypt\"},{\"countryNameCN\":\"赤道几内亚\",\"countryCode\":\"GQ\",\"countryNameEN\":\"Equatorial Guinea\"},{\"countryNameCN\":\"厄立特里亚\",\"countryCode\":\"ER\",\"countryNameEN\":\"Eritrea\"},{\"countryNameCN\":\"爱沙尼亚\",\"countryCode\":\"EE\",\"countryNameEN\":\"Estonia\"},{\"countryNameCN\":\"法属圭亚那\",\"countryCode\":\"GF\",\"countryNameEN\":\"French Guiana\"},{\"countryNameCN\":\"法属波利尼西亚\",\"countryCode\":\"PF\",\"countryNameEN\":\"French Polynesia\"},{\"countryNameCN\":\"加蓬\",\"countryCode\":\"GA\",\"countryNameEN\":\"Gabon\"},{\"countryNameCN\":\"冈比亚\",\"countryCode\":\"GM\",\"countryNameEN\":\"Gambia\"},{\"countryNameCN\":\"格鲁吉亚\",\"countryCode\":\"GE\",\"countryNameEN\":\"Georgia\"},{\"countryNameCN\":\"德国\",\"countryCode\":\"DE\",\"countryNameEN\":\"Germany\"},{\"countryNameCN\":\"加纳\",\"countryCode\":\"GH\",\"countryNameEN\":\"Ghana\"},{\"countryNameCN\":\"直布罗陀\",\"countryCode\":\"GI\",\"countryNameEN\":\"Gibraltar\"},{\"countryNameCN\":\"几内亚\",\"countryCode\":\"GN\",\"countryNameEN\":\"Guinea\"},{\"countryNameCN\":\"几内亚比绍\",\"countryCode\":\"GW\",\"countryNameEN\":\"Guinea Bissau\"},{\"countryNameCN\":\"香港\",\"countryCode\":\"HK\",\"countryNameEN\":\"Hong Kong\"},{\"countryNameCN\":\"匈牙利\",\"countryCode\":\"HU\",\"countryNameEN\":\"Hungary\"},{\"countryNameCN\":\"冰岛\",\"countryCode\":\"IS\",\"countryNameEN\":\"Iceland\"},{\"countryNameCN\":\"印度\",\"countryCode\":\"IN\",\"countryNameEN\":\"India\"},{\"countryNameCN\":\"伊拉克\",\"countryCode\":\"IQ\",\"countryNameEN\":\"Iraq\"},{\"countryNameCN\":\"伊朗\",\"countryCode\":\"IR\",\"countryNameEN\":\"Iran\"},{\"countryNameCN\":\"意大利\",\"countryCode\":\"IT\",\"countryNameEN\":\"Italy\"},{\"countryNameCN\":\"牙买加\",\"countryCode\":\"JM\",\"countryNameEN\":\"Jamaica\"},{\"countryNameCN\":\"约旦\",\"countryCode\":\"JO\",\"countryNameEN\":\"Jordan\"},{\"countryNameCN\":\"哈萨克斯坦\",\"countryCode\":\"KZ\",\"countryNameEN\":\"Kazakhstan\"},{\"countryNameCN\":\"科威特\",\"countryCode\":\"KW\",\"countryNameEN\":\"Kuwait\"},{\"countryNameCN\":\"利比里亚\",\"countryCode\":\"LR\",\"countryNameEN\":\"Liberia\"},{\"countryNameCN\":\"利比亚\",\"countryCode\":\"LY\",\"countryNameEN\":\"Libya\"},{\"countryNameCN\":\"澳门\",\"countryCode\":\"MO\",\"countryNameEN\":\"Macau\"},{\"countryNameCN\":\"马拉维\",\"countryCode\":\"MW\",\"countryNameEN\":\"Malawi\"},{\"countryNameCN\":\"马提尼克\",\"countryCode\":\"MQ\",\"countryNameEN\":\"Martinique\"},{\"countryNameCN\":\"毛里塔尼亚\",\"countryCode\":\"MR\",\"countryNameEN\":\"Mauritania\"},{\"countryNameCN\":\"毛里求斯\",\"countryCode\":\"MU\",\"countryNameEN\":\"Mauritius\"},{\"countryNameCN\":\"摩纳哥\",\"countryCode\":\"MC\",\"countryNameEN\":\"Monaco\"},{\"countryNameCN\":\"卢旺达\",\"countryCode\":\"RW\",\"countryNameEN\":\"Rwanda\"},{\"countryNameCN\":\"西萨摩亚\",\"countryCode\":\"WS\",\"countryNameEN\":\"Samoa\"},{\"countryNameCN\":\"沙特阿拉伯\",\"countryCode\":\"SA\",\"countryNameEN\":\"Saudi Arabia\"},{\"countryNameCN\":\"索马里\",\"countryCode\":\"SO\",\"countryNameEN\":\"Somalia\"},{\"countryNameCN\":\"南非\",\"countryCode\":\"ZA\",\"countryNameEN\":\"South Africa\"},{\"countryNameCN\":\"台湾\",\"countryCode\":\"TW\",\"countryNameEN\":\"Taiwan\"},{\"countryNameCN\":\"塔吉克斯坦\",\"countryCode\":\"TJ\",\"countryNameEN\":\"Tajikistan\"},{\"countryNameCN\":\"多哥\",\"countryCode\":\"TG\",\"countryNameEN\":\"Togo\"},{\"countryNameCN\":\"特利尼达和多巴哥\",\"countryCode\":\"TT\",\"countryNameEN\":\"Trinidad & Tobago\"},{\"countryNameCN\":\"突尼斯\",\"countryCode\":\"TN\",\"countryNameEN\":\"Tunisia\"},{\"countryNameCN\":\"土耳其\",\"countryCode\":\"TR\",\"countryNameEN\":\"Turkey\"},{\"countryNameCN\":\"阿拉伯联合酋长国\",\"countryCode\":\"AE\",\"countryNameEN\":\"United Arab Emirates\"},{\"countryNameCN\":\"英国\",\"countryCode\":\"GB\",\"countryNameEN\":\"United Kingdom\"},{\"countryNameCN\":\"美国\",\"countryCode\":\"US\",\"countryNameEN\":\"United States\"},{\"countryNameCN\":\"英属维尔京群岛\",\"countryCode\":\"VG\",\"countryNameEN\":\"Virgin islands British\"},{\"countryNameCN\":\"美属维尔京群岛\",\"countryCode\":\"VI\",\"countryNameEN\":\"Virgin Island U.S.\"},{\"countryNameCN\":\"赞比亚\",\"countryCode\":\"ZM\",\"countryNameEN\":\"Zambia\"},{\"countryNameCN\":\"津巴布韦\",\"countryCode\":\"ZW\",\"countryNameEN\":\"Zimbabwe\"},{\"countryNameCN\":\"其他国家\",\"countryCode\":\"OT\",\"countryNameEN\":\"Other Countries\"}]";
		JSONObject json;
		String table="";
		try {
			JSONArray array = new JSONArray(countryStr);
			for(int i=0;i<array.length();i++) {
				json = (JSONObject) array.get(i);
				table ="CREATE TABLE `item_country_"+json.getString("countryCode").toUpperCase()+"` (`itemID` varchar(40) NOT NULL,PRIMARY KEY (`itemID`)) ENGINE=InnoDB  DEFAULT CHARSET=utf8;";
				System.out.println(table);
				createtable(table);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void createtable(String sql) {
	        try {
	            Statement stmt = (Statement)conn.createStatement();
	            stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}
}
