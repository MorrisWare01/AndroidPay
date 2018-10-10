package com.morrisware.android.pay.wechat;

/**
 * Created by MorrisWare on 2018/9/29.
 * Email: MorrisWare01@gmail.com
 */
public class PayParams {

    String appId;
    String partnerId;
    String prepayId;
    String packageValue;
    String nonceStr;
    // 标准北京时间，时区为东八区，自1970年1月1日 0点0分0秒以来的秒数。注意：部分系统取到的值为毫秒级，需要转换成秒(10位数字)。
    String timestamp;
    String sign;

    private PayParams(Builder builder) {
        this.appId = builder.appId;
        this.partnerId = builder.partnerId;
        this.prepayId = builder.prepayId;
        this.packageValue = builder.packageValue;
        this.nonceStr = builder.nonceStr;
        this.timestamp = builder.timestamp;
        this.sign = builder.sign;
    }

    public static class Builder {
        private String appId;
        private String partnerId;
        private String prepayId;
        private String packageValue = "Sign=WXPay";
        private String nonceStr;
        // 标准北京时间，时区为东八区，自1970年1月1日 0点0分0秒以来的秒数。注意：部分系统取到的值为毫秒级，需要转换成秒(10位数字)。
        private String timestamp;
        private String sign;

        public Builder setAppId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder setPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Builder setPrepayId(String prepayId) {
            this.prepayId = prepayId;
            return this;
        }

        public Builder setPackageValue(String packageValue) {
            this.packageValue = packageValue;
            return this;
        }

        public Builder setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setSign(String sign) {
            this.sign = sign;
            return this;
        }

        public PayParams build() {
            return new PayParams(this);
        }
    }
}
