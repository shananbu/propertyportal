package com.ats.property.common.constants;

import com.ats.property.dto.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * The CommonHelper.
 *
 * @author anbarasan.s
 */
public class CommonHelper {

    static ObjectFactory objectFactory= null;

    static {
        objectFactory = new ObjectFactory();
    }

    public static MessageType getMessage(String msg, Integer code) {
        MessageType message = objectFactory.createMessageType();
        message.setMessage(msg);
        message.setCode(code);
        return message;
    }

    public static MessageType getMessage(ResponseMessage msg) {
        MessageType message = objectFactory.createMessageType();
        message.setMessage(msg.message());
        message.setCode(msg.code());
        return message;
    }

    public static MessageType getSuccessMessage() {
        return getMessage(ResponseMessage.SUCCESSFUL_RESPONSE.message(), ResponseMessage.SUCCESSFUL_RESPONSE.code());
    }

    public static MessageType getFailureMessage() {
        return getMessage(ResponseMessage.UNEXPECTED_ERROR.message(), ResponseMessage.UNEXPECTED_ERROR.code());
    }

    public static ModuleList getSuccessModuleList() {
        ModuleList moduleList = objectFactory.createModuleList();
        moduleList.getMessages().add(getSuccessMessage());
        ModuleType moduleType = getModule();
        ModuleResponseType moduleResponseType = objectFactory.createModuleResponseType();
        moduleType.setModuleResponse(moduleResponseType);
        moduleList.getModule().add(moduleType);
        return moduleList;
    }

    public static ModuleList getModuleListWithMessage(MessageType message) {
        ModuleList moduleList = objectFactory.createModuleList();
        moduleList.getMessages().add(message);
        return moduleList;
    }

    public static ModuleType getModule() {
        ModuleType moduleType = objectFactory.createModuleType();
        return moduleType;
    }
    public static ModuleType getFirstModule(ModuleList response) {
        ModuleType moduleType = response.getModule().get(0);
        return moduleType;
    }

    public static void parseLineByLine(String msg, List<String> descriptions) {
        StringBuffer sb = new StringBuffer(msg);
        descriptions.addAll(Arrays.asList(msg.split("\\r\\n")));
    }

    public static String getToken(String msgToEncrypt) {
        String uuid = UUID.randomUUID().toString();
        return uuid + "-" + msgToEncrypt.split("@")[0];
    }

    public static void main(String[] args) {
        System.out.print(getToken("shananbu@gmail.com"));
    }
}
