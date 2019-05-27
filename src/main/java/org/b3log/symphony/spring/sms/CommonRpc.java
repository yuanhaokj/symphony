package org.b3log.symphony.spring.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
public class CommonRpc {
    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAIOnIdgRZQ1JcT",
                "MW5kqZGxesyD1u3DCuU1uW3cSlzCpt");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15108213757");
//        request.putQueryParameter("TemplateCode", "SMS_163435918");
//        request.putQueryParameter("SignName", "股票通知");
//        request.putQueryParameter("TemplateParam", "asdfaf,sadfad,ajdfoafd,");
//        request.putQueryParameter("SmsUpExtendCode", "fasf");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            System.out.println(response.getHttpStatus());
            System.out.println(response.getHttpResponse().toString());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}