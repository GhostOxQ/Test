package base;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class Alipay {

	   public void myAlipay() throws AlipayApiException {
			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.ALIPAY_URL, AlipayConfig.APP_ID,AlipayConfig.PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGN_TYPE);
			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setBody("用户充值");//
			model.setSubject("XX平台APP");
			model.setOutTradeNo("自己系统内的订单编号");// outtradeno 生存订单
			model.setTimeoutExpress("60m");
			model.setTotalAmount("支付金额");
			model.setProductCode("QUICK_MSECURITY_PAY");
			request.setBizModel(model);
			request.setNotifyUrl(AlipayConfig.CALLBACK_URL);//异步回调url
				
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			// System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		}
}