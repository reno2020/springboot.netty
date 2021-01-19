package com.reno.springboot.business.service;

import com.alibaba.fastjson.JSON;
import com.reno.springboot.business.model.TestInfoReq;
import com.reno.springboot.business.model.TestInfoResp;
import com.sun.kernel.netty.annotation.NettyBusinessAnnotation;
import com.sun.kernel.netty.common.RequestHeader;
import com.sun.kernel.netty.common.RequestMessage;
import com.sun.kernel.netty.common.ResponseHeader;
import com.sun.kernel.netty.common.ResponseMessage;
import com.sun.kernel.netty.handler.AbstractCommonBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jhl
 * @title: 测试
 * @description: 测试  具体业务操作类  注意：填写注解 beancode不要重复
 * @date 2021-1-19
 */
@Component
@NettyBusinessAnnotation(code = 111, beanCode = "TestService", beanName = "测试")
public class TestService extends AbstractCommonBusiness {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    @Override
    protected ResponseMessage<?> createBusiness(String transCode, RequestMessage<?> msg) {
        RequestHeader reqHeader = msg.getRequestHeader();
        ResponseMessage<TestInfoResp> message = new ResponseMessage<TestInfoResp>();
        ResponseHeader respHeader = getBaseRespHeader(reqHeader);
        message.setResponseHeader(respHeader);
        TestInfoResp respInfo = new TestInfoResp();
        try {
            logger.info("TestService ===== ", msg.getRequestJson());
            RequestMessage<TestInfoReq> response = JSON.parseObject(msg.getRequestJson(), new com.alibaba.fastjson.TypeReference<RequestMessage<TestInfoReq>>() {
            });
            TestInfoReq baseInfoReq = response.getRequestBody();
            respInfo.setMessage("Test000");
            respInfo.setReqContent(baseInfoReq.getId() + "--" + baseInfoReq.getName());
        } catch (Exception ex) {

        }
        message.setResponseBody(respInfo);
        return message;

    }
}
