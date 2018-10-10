package com.morrisware.android.pay.alipay;

import android.text.TextUtils;

import java.util.Map;

/**
 * Created by MorrisWare on 2018/9/29.
 * Email: MorrisWare01@gmail.com
 */
public class PayResult {

    public static final String RESULT_STATUS_SUCCESS = "9000";
    public static final String RESULT_STATUS_CANCEL = "6001";

    // resultStatus是结果码(类型为字符串)
    private String resultStatus;
    // result是处理结果(类型为json结构字符串)
    private String result;
    // memo是描述信息(类型为字符串)
    private String memo;

    public PayResult(Map<String, String> rawResult) {
        if (rawResult == null) {
            return;
        }

        for (String key : rawResult.keySet()) {
            if (TextUtils.equals(key, "resultStatus")) {
                resultStatus = rawResult.get(key);
            } else if (TextUtils.equals(key, "result")) {
                result = rawResult.get(key);
            } else if (TextUtils.equals(key, "memo")) {
                memo = rawResult.get(key);
            }
        }
    }

    @Override
    public String toString() {
        return "resultStatus={" + resultStatus + "};memo={" + memo
            + "};result={" + result + "}";
    }

    /**
     * @return the resultStatus
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }
}
