package com.morrisware.android.pay.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by MorrisWare on 2018/9/29.
 * Email: MorrisWare01@gmail.com
 */
public class PayRequest {

    public boolean pay(Activity activity, PayParams payParams) {
        IWXAPI wxapi = WXAPIFactory.createWXAPI(activity.getApplicationContext(), null);
        wxapi.registerApp(payParams.appId);

        PayReq request = new PayReq();
        request.appId = payParams.appId;
        request.partnerId = payParams.partnerId;
        request.prepayId = payParams.prepayId;
        request.packageValue = payParams.packageValue;
        request.nonceStr = payParams.nonceStr;
        request.timeStamp = payParams.timestamp;
        request.sign = payParams.sign;
        return wxapi.sendReq(request);
    }
    
}
