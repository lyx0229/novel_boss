package com.novel.web.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * 获取配置信息
 * @author Administrator
 *
 */
@Component
@PropertySource("classpath:business.properties")
public class BusinessConfig {
    
    @Value("${GOODS_IMG}")
    public String GOODS_IMG;//礼物图片路径
    
    @Value("${RECHARGE_IMG}")
    public String RECHARGE_IMG;//充值模板图片路径
    
    @Value("${NOVEL_IMG}")
    public String NOVEL_IMG;//小说图片路径
    
    @Value("${BOOKS_URL}")
    public String BOOKS_URL;//小说路径
    
    @Value("${DOMAIN}")
    public String DOMAIN;//域名
}
