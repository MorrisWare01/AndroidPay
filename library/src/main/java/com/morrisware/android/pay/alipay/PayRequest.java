package com.morrisware.android.pay.alipay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * Created by MorrisWare on 2018/9/29.
 * Email: MorrisWare01@gmail.com
 */
public class PayRequest {

    /**
     * 支付宝支付
     *
     * @param orderInfo   服务器返回加签的支付信息
     * @param payCallback 支付结结果：对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
     */
    public void pay(final Activity activity, final String orderInfo, final PayCallback payCallback) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                final PayResult payResult = new PayResult(result);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        switch (payResult.getResultStatus()) {
                            case PayResult.RESULT_STATUS_SUCCESS:
                                payCallback.onComplete();
                                break;
                            case PayResult.RESULT_STATUS_CANCEL:
                                payCallback.onCancel();
                                break;
                            default:
                                payCallback.onError(payResult);
                                break;
                        }
                    }
                });
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 支付宝支付
     */
    public void pay(Activity activity, Map<String, String> orderMap, PayCallback payCallback) {
        pay(activity, OrderInfoUtil2_0.buildOrderParam(orderMap), payCallback);
    }

}
