package com.cgs.utils;

import com.cgs.constant.MessageCodeConstants;
import com.cgs.entity.base.Message;

/**
 * Created by Administrator on 2017/7/5.
 */
public class MessageGenerator {

    public enum MessageCode {
        COMMON_SUCCESS,
        COMMON_SERVER_ERROR,
        COMMON_REQUEST_TOO_MUNCH,
        COMMON_ACCESS_TOKEN_REQUIRED,
        COMMON_ACCESS_TOKEN_INVALID
    }

    public Message create(MessageCode code) {
        return this.create(code,null);
    }

    public Message create(MessageCode code, Object data) {
        Message msg;
        switch (code) {
            // common
            case COMMON_SUCCESS:
                msg = new Message(MessageCodeConstants.SERVER＿SUCCESS, data);
                break;
            case COMMON_SERVER_ERROR:
                msg = new Message(MessageCodeConstants.INNER_ERROR);
                break;
            case COMMON_REQUEST_TOO_MUNCH:
                msg = new Message(MessageCodeConstants.REQUEST_TOO_MUCH);
                break;
            case COMMON_ACCESS_TOKEN_REQUIRED:
                msg = new Message(MessageCodeConstants.ACCESS_TOKEN_REQUIRED);
                break;
            case COMMON_ACCESS_TOKEN_INVALID:
                msg = new Message(MessageCodeConstants.ACCESS_TOKEN_INVALID);
                break;
            default:
                msg = new Message(MessageCodeConstants.MESSAGE_UNDEFINED);
                break;
        }
        return msg;
    }
}
