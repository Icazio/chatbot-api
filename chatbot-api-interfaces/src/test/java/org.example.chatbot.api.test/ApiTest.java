package org.example.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

public class ApiTest {
    @Test
    //用于调用问题接口
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885882122182/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"212554824112151\",\"first_id\":\"186beb6674f378-0a007ddb9e842e-7d5d5475-1382400-186beb66754cff\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YmViNjY3NGYzNzgtMGEwMDdkZGI5ZTg0MmUtN2Q1ZDU0NzUtMTM4MjQwMC0xODZiZWI2Njc1NGNmZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU1NDgyNDExMjE1MSJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"212554824112151\"},\"$device_id\":\"186beb6674f378-0a007ddb9e842e-7d5d5475-1382400-186beb66754cff\"}; UM_distinctid=186d12f358e527-0aeca90057fec5-7d5d5475-151800-186d12f358f622; abtest_env=product; zsxq_access_token=1432BDA5-5626-7DB9-3365-CB571C74DDF0_164CFF61E7769247; zsxqsessionid=221ccd824146e63c06aad57e443747ed");
        get.addHeader("content-type","application/json; charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println("succeed:"+res);
        }else System.out.println("failed:"+response.getStatusLine().getStatusCode());

    }


    //用于调用答案接口
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post=new HttpPost("https://api.zsxq.com/v2/topics/584184512211414/answer");
        post.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"212554824112151\",\"first_id\":\"186beb6674f378-0a007ddb9e842e-7d5d5475-1382400-186beb66754cff\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2YmViNjY3NGYzNzgtMGEwMDdkZGI5ZTg0MmUtN2Q1ZDU0NzUtMTM4MjQwMC0xODZiZWI2Njc1NGNmZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU1NDgyNDExMjE1MSJ9\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"212554824112151\"},\"$device_id\":\"186beb6674f378-0a007ddb9e842e-7d5d5475-1382400-186beb66754cff\"}; UM_distinctid=186d12f358e527-0aeca90057fec5-7d5d5475-151800-186d12f358f622; abtest_env=product; zsxq_access_token=1432BDA5-5626-7DB9-3365-CB571C74DDF0_164CFF61E7769247; zsxqsessionid=221ccd824146e63c06aad57e443747ed");
        post.addHeader("content-type","application/json;charset=utf8");
        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"尝试从IDEA跑程序回复（此回答用于获取回答的json数据）\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse execute=httpClient.execute(post);
        if(execute.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(execute.getEntity(),"utf-8");
            System.out.println("succeed:"+res);
        }else System.out.println("failed:"+execute.getStatusLine().getStatusCode());


    }
}

