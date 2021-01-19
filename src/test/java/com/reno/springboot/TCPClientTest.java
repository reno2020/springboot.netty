package com.reno.springboot;


import com.reno.springboot.business.model.TestInfoReq;;
import com.sun.kernel.netty.client.NettySocketClient;
import com.sun.kernel.netty.common.RequestHeader;
import com.sun.kernel.netty.common.RequestMessage;
import com.sun.kernel.netty.utils.ReqRespUtils;
import org.junit.Test;

public class TCPClientTest {

	@Test
	public final void testService() throws Exception {
		RequestMessage<TestInfoReq> reqMsg = new RequestMessage<TestInfoReq>();
		TestInfoReq reqBody = new TestInfoReq();
		reqBody.setId("000111");
		reqBody.setName("my-test");

		RequestHeader reqHeader = new RequestHeader();
		reqHeader.setTransCode("TestService");

		reqHeader.setBusinessId("B1000666");
		reqHeader.setSrcReqDate("20201111");
		reqHeader.setSrcReqTime("131212");
		reqHeader.setSrcReqId("001");

		reqMsg.setRequestHeader(reqHeader);

		reqMsg.setRequestBody(reqBody);

		String content = ReqRespUtils.requestMessageToJson(reqMsg);

		NettySocketClient client = new NettySocketClient();

		testSend(client,content);


	}

	public void testSend(NettySocketClient client,String content) throws Exception{
		for(int i=0;i<1;i++){
			System.out.println("=================start send===================");
			System.out.println(client.sendAndRecv(content, "GBK", "127.0.0.1", 8888));
			System.out.println("=================end   send===================");
		}
	}




}
