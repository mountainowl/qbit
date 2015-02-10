package io.advantageous.qbit.spi;

import io.advantageous.qbit.http.HttpRequest;
import io.advantageous.qbit.http.HttpServer;
import io.advantageous.qbit.http.WebSocketMessage;
import io.advantageous.qbit.queue.Queue;


public interface HttpServerFactory {

    HttpServer create(String host, int port, boolean manageQueues,
         int pollTime,
         int requestBatchSize,
         int flushInterval, int maxRequests
         );

    default HttpServer createWithWorkers(String host, int port, boolean manageQueues,
                                         int pollTime,
                                         int requestBatchSize,
                                         int flushInterval, int maxRequests, int httpWorkers, Class handler
    ) {
        throw new RuntimeException("NOT IMPLEMENTED BY FACTORY " + this.getClass());
    }


    default HttpServer createHttpServerWithQueue(final String host, final int port,
                                                 final int flushInterval, final Queue<HttpRequest> requestQueue,
                                                 final Queue<WebSocketMessage> webSocketMessageQueue) {
        throw new RuntimeException("createHttpServerWithQueue NOT IMPLEMENTED BY FACTORY " + this.getClass());
    }
}