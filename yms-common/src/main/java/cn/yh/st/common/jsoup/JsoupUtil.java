package cn.yh.st.common.jsoup;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.yh.st.common.util.StringUtil;

public class JsoupUtil {

	private static int TIME_OUT = 10000;

	/**
	 * @Description 将所有https的网站添加信任 爬取https网站时需要
	 */
	private static void addHttpsTrust() {
		try {
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[] { new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			} }, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description 获取页面信息
	 * @param rule
	 *            请求规则
	 * @return 页面的document对象
	 * @throws Exception
	 */
	private static Connection getConnectionByRule(String url, List<JsoupParam> params)
			throws Exception {
		if (StringUtil.isEmpty(url)) {
			throw new Exception("URL不合法");
		}
		// 添加https信任
		if (url.startsWith("https://")) {
			addHttpsTrust();
		}
		// 获取连接
		Connection conn = Jsoup.connect(url);
		conn.userAgent("Mozilla");
		// 设置查询参数
		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				conn.data(params.get(i).getParamName(), params.get(i).getParamValue());
			}
		}
		return conn;
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Document getDocumentByPost(String url, List<JsoupParam> params) throws Exception {
		Connection conn = getConnectionByRule(url, params);
		return conn.timeout(TIME_OUT).post();
	}

	/**
	 * get请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Document getDocumentByGet(String url, List<JsoupParam> params) throws Exception {
		Connection conn = getConnectionByRule(url, params);
		return conn.timeout(TIME_OUT).get();
	}

}
