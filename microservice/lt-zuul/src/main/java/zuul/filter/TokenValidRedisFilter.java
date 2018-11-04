package zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import zuul.constant.AuthConstants;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenValidRedisFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String header = request.getHeader("Authorization");
        if (header.startsWith("Bearer")) {
            String realHead = AuthConstants.REDIS_PREFIX + "auth:" + header.replaceFirst("Bearer ", "");
            String redisHead = stringRedisTemplate.boundValueOps(realHead).get();
            if (redisHead == null) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.setResponseBody("{\"result\":\"令牌已失效，请重新登录!\"}");
                ctx.getResponse().setContentType("text/html;charset=UTF-8");
            }
        }
        return null;

    }
}
