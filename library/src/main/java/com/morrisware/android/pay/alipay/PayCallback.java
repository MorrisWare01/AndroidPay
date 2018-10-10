package com.morrisware.android.pay.alipay;

/**
 * Created by MorrisWare on 2018/9/30.
 * Email: MorrisWare01@gmail.com
 */
public abstract class PayCallback {

    public abstract void onComplete();

    public void onCancel() {

    }

    public void onError(PayResult payResult) {

    }

}
