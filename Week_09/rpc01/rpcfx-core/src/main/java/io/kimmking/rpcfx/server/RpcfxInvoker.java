package io.kimmking.rpcfx.server;

import io.kimmking.rpcfx.api.*;
import io.kimmking.rpcfx.common.InvokerFactory;

public class RpcfxInvoker {

    private RpcfxResolver resolver;

    public RpcfxInvoker(RpcfxResolver resolver){
        this.resolver = resolver;
    }

    public RpcfxResponse invoke(RpcfxRequest request) {
        RpcfxResponse response = new RpcfxResponse();
        String serviceClass = request.getServiceClass();
        try {
            Object service = resolver.resolve(serviceClass);
            RpcInvoker rpcInvoker = InvokerFactory.getInvoker(service.getClass());
            Object result = rpcInvoker.invoke(service, request.getMethod(), request.getParams());
            response.setResult(result);
            response.setStatus(true);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            // 2.封装一个统一的RpcfxException
            // 客户端也需要判断异常
            RpcfxException rpcfxException = new RpcfxException(e.getMessage(),e.getCause());
            response.setException(rpcfxException);
            response.setStatus(false);
            return response;
        }
    }



}
