package com.imooc.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>创建商户响应对象</h2>
 * Created by Zhangli.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {

    /** 商户 id: 创建失败则为 -1 */
    private Integer id;
}
