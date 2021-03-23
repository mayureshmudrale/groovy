@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.2')

import groovy.json.*
import org.apache.http.client.methods.*

import org.apache.http.impl.client.*
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

List<NameValuePair> requestbody = new ArrayList<NameValuePair>(1);
            requestbody.add(new BasicNameValuePair("grant_type", "client_credentials"));
            requestbody.add(new BasicNameValuePair("client_id", "b337f964-6322-4675-b545-b30bce7137cf@6d14682b-68a6-4a25-af3d-06615e146b1e"));
            requestbody.add(new BasicNameValuePair("client_secret", "p+DLdqlYRWdECdoqT9xaULTknfA/zQ2tSSbh4q5kqnE="));
            requestbody.add(new BasicNameValuePair("resource","00000003-0000-0ff1-ce00-000000000000/drlglobal.sharepoint.com@6d14682b-68a6-4a25-af3d-06615e146b1e "));
            




def connection = new HttpPost('https://accounts.accesscontrol.windows.net/6d14682b-68a6-4a25-af3d-06615e146b1e/tokens/OAuth/2')

connection.addHeader("content-type","application/x-www-form-urlencoded")
connection.addHeader("Cookie", "esctx=AQABAAAAAAD--DLA3VO7QrddgJg7WevrORfQqCFXaNckOmdJfBsRPpJI2flg8CF2-A5BUxzdtolVLpzLNNnpoAvXCEcnVJiSwhhsn6xzZK731i0GskzuwCdspCHajEoZoaanpIXqKBbesg9w9pVqB33fTNWaeqz6zojTiin4_JMNScE9z3CBLSwr1YhI5jXzzXS0UVXlzoAgAA; x-ms-gateway-slice=estsfd; stsservicecookie=estsfd; fpc=AtTRNt9-gKdLoVSw6wpL13ABGv5BAQAAANkh6tcOAAAA")
connection.setEntity(new UrlEncodedFormEntity(requestbody))



def client = HttpClientBuilder.create().build()
def response = client.execute(connection)

def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))


def slurper = new JsonSlurper()
def res = slurper.parseText(bufferedReader.getText())
def access_token=res.access_token
println access_token