学习笔记

作业1：整合上次作业的 httpclient/okhttp；
HttpOutboundHandler

作业3：实现过滤器

```java
public class HttpHeadersFilter implements HttpRequestFilter{

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio","bruce");
    }
}
```



