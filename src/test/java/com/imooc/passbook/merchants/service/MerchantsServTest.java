package com.imooc.passbook.merchants.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.merchants.vo.CreateMerchantsRequest;
import com.imooc.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**<h1>商户服务测试类</h1>
 * Created by Zhangli.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    /** {"data":{"id":17}}
     *  {"data":{"id":18}}
     */
    @Test
//    @Transactional
    public void testCreateMerchantServ() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("1234567890");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    /** {"data":{"address":"北京市","businessLicenseUrl":"www.imooc.com","id":19,"isAudit":false,
     * "logoUrl":"www.imooc.com","name":"慕课","phone":"1234567890"}}
     */
    @Test
    public void testBuildMerchantsInfoById() {
        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(19)));
    }

    /**
     * {"background":2,"desc":"详情: 慕课","end":1544276206053,"hasToken":false,"id":19,"limit":10000,
     * "start":1543412206053,"summary":"简介: 慕课","title":"title: 慕课"}
     */
    @Test
    public void testDropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(19);
        passTemplate.setTitle("title: 慕课");
        passTemplate.setSummary("简介: 慕课");
        passTemplate.setDesc("详情: 慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}
