package eleme;

import java.util.List;

import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;

public class GetToken {

    public static void main(String[] args) throws ServiceException {

        // 变量为true: 沙箱环境 false: 生产环境
        boolean isSandbox = true;

        // 当前环境key
        String appKey = "nLvQioMQe4";

        // 当前环境secret
        String appSecret = "848b9cd9ffe364c9d8ce24d7019ad299c6c97d14";

        // 实例化一个配置类
        Config config = new Config(isSandbox, appKey, appSecret);

        // 使用config对象，实例化一个授权类
        OAuthClient client = new OAuthClient(config);

        // 根据OAuth2.0中的对应state，scope和callback_url，获取授权URL
        //String authUrl = client.getAuthUrl("https://sso.800best.com", "all", "1");
        //System.out.println(authUrl);


        // 通过授权得到的code，以及正确的callback_url，获取token
        Token token = client
                .getTokenByCode("efb18c7834d538e6d4c32f17dc0e356f", "https://sso.800best.com");
        System.out.println(token);

        //oauth request id is E3D60B5B85764E568532C8064063F34C|1534824581673
        //Token{accessToken='b5226b789627eb1c1ab058be84f6f7b8', tokenType='Bearer', expires=86400, refreshToken='6f3eb6758e2fe132922a3b263bbe32f4'}


        ProductService productService = new ProductService(config, token);
        List<OCategory> shopCategories = productService.getShopCategories(166038617L);
        for (OCategory shopCategory : shopCategories) {
            System.out.println(shopCategory.getName());

        }
    }
}

//
//open-api-sandbox.shop.ele.me/authorize?
//        response_type=code
//        &client_id=nLvQioMQe4
//        &redirect_uri=https%3a%2f%2fsso.800best.com&state=1&scope=all
//
//回调：
//sso.800best.com/?code=91b6c2f12cfefa0d021a72ce6bccbeae&state=76074702-b42a-4f00-b7fc-ed4b1bef88ed