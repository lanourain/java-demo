import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
    /**
     * get请求
     * @param url
     * @return
     */
    public static String get(String url){
        return getAll(url, null);
    }

    /**
     * get请求，包括headers
     * @param url
     * @param headers
     * @return
     */
    public static String getAll(String url, Map<String, String> headers){
        return isBlank(url) ? null : execute(addHeaders(new HttpGet(url), headers));
    }

    /**
     * post请求
     * @param url
     * @return
     */
    public static String post(String url){
        return postAll(url, null, null);
    }

    /**
     * post请求，添加headers
     * @param url
     * @param headers
     * @return
     */
    public static String postWithHeaders(String url, Map<String, String> headers){
        return postAll(url, null, headers);
    }

    /**
     * post请求，添加params
     * @param url
     * @param params
     * @return
     */
    public static String postWithParams(String url, Map<String, String> params){
        return postAll(url, params, null);
    }

    /**
     * post请求，包括params和headers
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static String postAll(String url, Map<String, String> headers, Map<String, String> params){
        String res = null;

        try {
            if (!isBlank(url)) {
                res = execute(addHeaders(addParams(new HttpPost(url), params), headers));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     * 添加头信息
     * @param request
     * @param headers
     * @return
     */
    private static HttpRequestBase addHeaders(HttpRequestBase request, Map<String, String> headers){
        if (headers != null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                request.addHeader(key, headers.get(key));
            }
        }

        return request;
    }

    /**
     * 添加参数
     * @param post
     * @param params
     * @return
     */
    private static HttpPost addParams(HttpPost post, Map<String, String> params){
        try {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if (params != null && !params.isEmpty()) {
                for (String key : params.keySet()) {
                    nvps.add(new BasicNameValuePair(key, params.get(key)));
                }
            }
            post.setEntity(new UrlEncodedFormEntity(nvps));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }

    /**
     * 执行请求
     * @param request
     * @return
     */
    private static String execute(HttpRequestBase request){
        String res = null;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            try {
                ResponseHandler<String> handler = new ResponseHandler<String>() {
                    public String handleResponse(final HttpResponse response){
                        try {
                            int status = response.getStatusLine().getStatusCode();
                            if (status >= 200 && status < 300) {
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity) : null;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return null;
                    }
                };

                res = httpclient.execute(request, handler);
            } finally {
                httpclient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    private static final boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        if (string.length() == 0) {
            return true;
        }
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}