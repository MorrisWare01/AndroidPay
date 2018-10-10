package com.morrisware.android.pay;

import com.morrisware.android.pay.wechat.PayRequest;

/**
 * Created by MorrisWare on 2018/9/29.
 * Email: MorrisWare01@gmail.com
 */
public class Pay {

    public static PayRequest wechat() {
        return new PayRequest();
    }

    public static com.morrisware.android.pay.alipay.PayRequest alipay() {
        return new com.morrisware.android.pay.alipay.PayRequest();
    }

}
