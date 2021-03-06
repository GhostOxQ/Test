package base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class I_Http {
	public static void Get(String myurl) {
	    try {
	        URL url = new URL(myurl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoOutput(true); // 设置该连接是可以输出的
	        connection.setRequestMethod("GET"); // 设置请求方式
	        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
	        String line = null;
	        StringBuilder result = new StringBuilder();
	        while ((line = br.readLine()) != null) { // 读取数据
	            result.append(line + "\n");
	        }
	        connection.disconnect();
	        System.out.println(result.toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
