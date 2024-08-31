package org.lyflexi.debug_basicjdk.exception;

import lombok.Getter;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/13 13:38
 */

@Getter
public enum LyflexiErrorType implements ErrorType {
    INTERNET_SERVER_ERROR("000001", "服务器内部错误"),
    NO_PULL_REPLENISH_CONFIG("050001", "物料【%s】-【%s】-【%s】物料拉动信息配置不存在或未启用，请维护！"),
    ;
    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String mesg;

    LyflexiErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
