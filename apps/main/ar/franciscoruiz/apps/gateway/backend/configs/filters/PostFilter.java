package ar.franciscoruiz.apps.gateway.backend.configs.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public final class PostFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(PostFilter.class);


    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext     ctx     = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("Post filter");
        log.info("Context path: " + request.getContextPath());
        log.info("Method: " + request.getMethod());


        Long initialTime = (Long) request.getAttribute("initialTime");
        Long finalTime   = System.currentTimeMillis();
        Long timeElapsed = finalTime - initialTime;

        log.info(String.format("Time %s seg.", timeElapsed.doubleValue() / 1000.00));
        log.info(String.format("Time %s ms.", timeElapsed));
        return null;
    }
}
