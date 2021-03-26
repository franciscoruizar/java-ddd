package ar.franciscoruiz.apps.gateway.backend.configs.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public final class ErrorFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
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

        log.error("Error filter");
        log.error("Context path: " + request.getContextPath());
        log.info("Method: " + request.getMethod());


        Long initialTime = (Long) request.getAttribute("initialTime");
        Long finalTime   = System.currentTimeMillis();
        Long timeElapsed = finalTime - initialTime;

        log.error(String.format("Time %s seg.", timeElapsed.doubleValue() / 1000.00));
        log.error(String.format("Time %s ms.", timeElapsed));
        return null;
    }
}
