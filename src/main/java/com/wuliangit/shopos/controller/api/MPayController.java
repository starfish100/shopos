package com.wuliangit.shopos.controller.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.pay.AliPay;
import com.wuliangit.shopos.controller.TestController;
import com.wuliangit.shopos.entity.Order;
import com.wuliangit.shopos.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * Created by nilme on 2017/5/10.
 */

@Controller
@RequestMapping(value = "/api/v1/pay")
public class MPayController {
    private static Log logger = LogFactory.getLog(MPayController.class);
    private String notifyUrl = "http://shop.wuliangit.com/api/v1/pay/alipay/notify";

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/alipay/prepare", method = RequestMethod.POST)
    @ResponseBody
    public Object alipayPrepare(Integer[] orderIds) throws AlipayApiException {
        RestResult result = new RestResult();

        AlipayClient alipayClient = AliPay.getAlipayClient();
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

        //合并的订单id
        String outTradeNoMerge = UUID.randomUUID().toString().replaceAll("-", "");

        BigDecimal totalAmount = new BigDecimal(0);

        for (Integer orderId : orderIds) {
            Order order = orderService.getOrderById(orderId);
            totalAmount.add(order.getOrderAmount());
            if (orderIds.length > 1) {
                order.setOutTradeNoMerge(outTradeNoMerge);
                int res = orderService.updateOrder(order);
            }
        }


        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        if (orderIds.length > 1) {
            model.setOutTradeNo(outTradeNoMerge);
            model.setBody("合并订单");
        } else {
            model.setBody("商品订单");
        }
        model.setSubject("商品支付");
        model.setTimeoutExpress("30m");
        model.setTotalAmount(totalAmount.toString());
        model.setProductCode(AliPay.PRODUCTCODE);

        request.setBizModel(model);
        request.setNotifyUrl(notifyUrl);
        try {
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            result.add("payInfo", response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            System.out.println(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return result;
    }



    @RequestMapping("/alipay/notify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean flag = AlipaySignature.rsaCheckV1(params, AliPay.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8, AlipayConstants.SIGN_TYPE_RSA2);

        //验证通过，处理业务逻辑
        if (flag){

        }


        logger.debug("支付宝异步通知");

        PrintWriter out = response.getWriter();
        out.println("success"); // 请不要修改或删除
        out.flush();
    }
}
