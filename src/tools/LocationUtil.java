package tools;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

public class LocationUtil {
    /**
     *
     * 输入经纬度坐标返回地址 key lon(经度),lat(纬度)
     */
    public LocationUtil(){}

    public static String getPosition(double lat, double lon) {
        String ak= "wKUfa4Zk2QZfY767GfmXWMGjpzm8DoKQ";
        String url="http://api.map.baidu.com/reverse_geocoding/v3/?ak="+ak+"&output=json&coordtype=wgs84ll&location="+ lat +","+ lon;

//        JSONObject json=new JSONObject();
        String temp=sendGet(url);
        System.out.println(temp);
        String result= JSONObject.fromObject(temp).getString("result");

//        System.out.println("Test"+JSONObject.fromObject(result).getString("formatted_address"));
        return JSONObject.fromObject(result).getString("formatted_address");
    }


    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        LocationUtil test=new LocationUtil();
        String res = getPosition(23.156206,113.332264);
        System.out.println(res);
        byte[] utf8=res.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(utf8, StandardCharsets.UTF_8));
    }
}