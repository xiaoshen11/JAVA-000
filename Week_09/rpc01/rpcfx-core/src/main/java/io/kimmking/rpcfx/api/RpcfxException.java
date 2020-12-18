package io.kimmking.rpcfx.api;

public class RpcfxException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Tcc exception.
     */
    public RpcfxException() {
    }

    /**
     * Instantiates a new Rpcfx exception.
     *
     * @param message the message
     */
    public RpcfxException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Rpcfx exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public RpcfxException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Rpcfx exception.
     *
     * @param cause the cause
     */
    public RpcfxException(final Throwable cause) {
        super(cause);
    }
}
